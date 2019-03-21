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
						channel = SocketChannel.open();
						channel.configureBlocking(false);
						Selector selector=Selector.open();
						channel.connect(new InetSocketAddress("localhost", 10086));
						channel.register(selector, SelectionKey.OP_CONNECT);
						while(true) {
							selector.select();
							Iterator<SelectionKey> ite=selector.selectedKeys().iterator();
							while(ite.hasNext()) {
								SelectionKey key=ite.next();
								ite.remove();
								if(key.isConnectable()) {
									SocketChannel socketChannel=(SocketChannel) key.channel();
									if(socketChannel.isConnectionPending())
										socketChannel.finishConnect();
									socketChannel.configureBlocking(false);
									socketChannel.write(ByteBuffer.wrap(new String("服务器你好").getBytes("utf-8")));
									socketChannel.register(selector, SelectionKey.OP_READ);
									
								}else if(key.isReadable()) {
									SocketChannel socketChannel=(SocketChannel) key.channel();
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
