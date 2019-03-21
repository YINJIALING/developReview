package io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * https://zhuanlan.zhihu.com/p/40317677
 * 有一个独立的线程监听客户端的链接，每次接收到的客户端请求都会为该请求创建一个新的线程负责与客户端 的数据收发
 * 每当有一个新的客户端接入时，服务端创建一个新的线程来处理
 * 在高性能，高并发的场景下无法应用（大量创建新的线程会严重影响服务器性能，甚至罢工）
 * 一客户端一个线程
 */

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(10086);
		System.out.println("等待客户端连接");
		while(true) {
			Socket socket=server.accept();
			new Thread(new SocketThread(socket)).start();;
		}
	}

}
