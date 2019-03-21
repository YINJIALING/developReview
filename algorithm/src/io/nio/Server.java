package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
/**
 * new io,根据老的io库进行新增，也叫non-block io.
 * 老模型中socket和serverSocket相对应的socketChannel和serverSocketChannel两种通道。
 * 新增的两种通道都支持阻塞和非阻塞。阻塞模式使用的时候和老模型中一样
 * 对于低负载，低并发的应用程序，可以使用同步阻塞io 提升开发速率和更好的维护性；对于高负载，高并发的应用，使用nio的非阻塞模式来开发
 * @author yinjialing
 * 一些概念：
 * 缓冲区(实际上是一个数组)：所有的数据都是用缓冲区处理的，读取数据时，直接读到缓冲区；在写入数据时，也是写入缓冲区。任何时候访问nio中的数据都是通过缓冲区进行操作。
 * channel:对数据的读取和写入要通过通道，可以用于读，写和同时读写。
 * 多路复用器selector:提供选择已经就绪任务的能力，它会不断轮询在注册在它上的channel，如果某个channel上发生读或写，这个channel就处于就绪状态，会被selector轮询出来，通过selectionKey可以获取就绪的channel集合，之后进行后续的io操作。
 * 一个selector可以同时轮询多个channel,jdk使用epoll()代替传统的select实现，所以没最大连接句柄的限制。
 * 因此，只需要一个线程负责selector的轮询，就可以接入成千上万的客户端。
 */
/**
 * 创建一个nio服务器的主要步骤
 * @author yinjialing
 * 1.打开serverSocketChannel,监听客户端的连接
 * 2.绑定监听端口，设置连接为非阻塞模式
 * 3.创建Reactor线程，创建多路复用器并启动线程
 * 4.将ServerSocketChannel注册到Reactor线程中的seletor上， 监听accept事件
 * 5.selector轮询准备就绪的key
 * 6.selector监听到新的客户端接入，处理新的接入请求，完成tcp三次握手
 * 7.设置客户端链路为非阻塞模式
 * 8.将新接入的客户端连接注册到Reactor线程的多路复用器上，监听读操作，读取客户端发送的网络消息
 * 9.异步读取客户端消息到缓冲区
 * 10.对buffer编解码，处理半包消息，将解码成功的消息封装成task
 * 11.将应答信息编码为buffer,调用socketchannel的write将消息异步发送给客户端。
 */
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
