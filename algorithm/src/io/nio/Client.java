package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {

	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					SocketChannel channel;
					try {
						channel = SocketChannel.open();//获得一个通道，并打开通道
						channel.configureBlocking(false);//设为非阻塞
						Selector selector=Selector.open();//获得一个selector
						
						//客户端连接服务器，但方法执行没有实现连接，需要在listen()中调用channel.finishConnect()才能完成连接
						channel.connect(new InetSocketAddress("localhost", 10086));
						//将通道管理器和该通道绑定，并为该通道注册OP_CONNECT事件
						channel.register(selector, SelectionKey.OP_CONNECT);
						
						//采用轮询的方式监听selector上是否有需要处理的事件，如果有，就进行处理
						while(true) {
							
							selector.select();
						//获得selector中选中的项的迭代器
							Iterator<SelectionKey> ite=selector.selectedKeys().iterator();
							while(ite.hasNext()) {
								SelectionKey key=ite.next();
								//删除已选 的key，以防重复处理
								ite.remove();
								if(key.isConnectable()) {//连接事件发生
									SocketChannel socketChannel=(SocketChannel) key.channel();
									// 如果正在连接，就完成连接
									if(socketChannel.isConnectionPending())
										socketChannel.finishConnect();
									socketChannel.configureBlocking(false);//设为非阻塞
									//给服务器发消息
									socketChannel.write(ByteBuffer.wrap(new String("服务器你好").getBytes("utf-8")));
									//在和服务器连接成功后，为了可以接受服务端的信息，给通道设置读的权限
									socketChannel.register(selector, SelectionKey.OP_READ);
									
								}else if(key.isReadable()) {//获得了可读的事件
									//服务器可读取消息，得到事件发生的socket通道
									SocketChannel socketChannel=(SocketChannel) key.channel();
									//创建读取的缓冲区
									ByteBuffer buffer=ByteBuffer.allocate(512);
									socketChannel.read(buffer);
									byte[] data=buffer.array();
									String msg=new String(data).trim();
									System.out.println("接收到服务器发来的数据"+msg);
								}
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}}).start();
		}
	}

}
