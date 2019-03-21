package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel server=ServerSocketChannel.open();//打开通道
		server.configureBlocking(false);//设为非阻塞
		server.bind(new InetSocketAddress(10086));
		Selector selector=Selector.open();//获得一个selector
		
		//将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件，注册改事件后
		//当该事件到达时，selector.select()会返回。如果该事件没到达selector.select()会阻塞。
		server.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("等待客户端链接");
		
		//采用轮询的方式监听selector上是否有需要处理的事件，如果有，就进行处理
		while(true) {
			//当注册的事件到达，方法返回；否则，该方法一直阻塞
			selector.select();
			//获得selector中选中的项的迭代器，选中的项为注册的事件
			Iterator<SelectionKey> ite=selector.selectedKeys().iterator();
			while(ite.hasNext()) {
				SelectionKey key=ite.next();
				
				//删除已选 的key，以防重复处理
				ite.remove();
				if(key.isAcceptable()) {//客户端请求连接事件
					ServerSocketChannel serverSocketChannel=(ServerSocketChannel) key.channel();
					//获得和客户端链接的通道
					SocketChannel channel=serverSocketChannel.accept();
					//设为非阻塞
					channel.configureBlocking(false);
					//给客户端发送信息
					channel.write(ByteBuffer.wrap(new String("客户端你好").getBytes("utf-8")));
					//和客户端连接成功后，为了可以接收到客户端的信息，需要给通道设置读的权限
					channel.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()) {//获得了可读的事件
					//服务器可读取消息，得到事件发生的socket通道
					SocketChannel channel=(SocketChannel) key.channel();
					//创建读取的缓冲区
					ByteBuffer buffer=ByteBuffer.allocate(512);
					channel.read(buffer);
					byte[] data=buffer.array();
					String msg=new String(data).trim();
					System.out.println("接受到客户端发来的数据："+msg);
				}
			}
		}
	}
}
