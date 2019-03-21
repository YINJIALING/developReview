package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 1.向服务器端发请求，如果无响应会等待或拒绝请求
 * 
 * @author YJL
 *
 */
public class Client {

	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Socket client=new Socket("localhost",10086);
						OutputStream os=client.getOutputStream();
						PrintWriter pw=new PrintWriter(os);
						pw.write("服务器你好");
						pw.flush();
						client.shutdownOutput();
						
						InputStream is=client.getInputStream();
						InputStreamReader isr=new InputStreamReader(is);
						BufferedReader br=new BufferedReader(isr);
						String temp=null;
						while((temp=br.readLine())!=null) {
							System.out.println("接收到服务器发来的数据："+temp);
						}
						
						br.close();isr.close();is.close();pw.close();os.close();client.close();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();;
		}
	}

}
