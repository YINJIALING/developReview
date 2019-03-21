package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread implements Runnable {
	private Socket socket;
	
	public SocketThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream in;
		try {
			in = socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(isr);
			String temp=null;
			while((temp=br.readLine())!=null) {
				System.out.println("接受端口号为"+socket.getPort()+"客户端发来的数");
			}
			socket.shutdownInput();
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("客户端你好");
			pw.flush();
			pw.close();os.close();br.close();isr.close();socket.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
