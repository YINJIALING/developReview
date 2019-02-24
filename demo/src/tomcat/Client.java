package tomcat;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			
			//构建IO
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
			//向服务器端发送一条消息
			bw.write("通信，服务器接收到消息返回到客户端\n");
			bw.flush();
			//读取服务器返回的消息
			StringBuffer sb=new StringBuffer();
			int len=0;
			byte[] buff =new byte[1024];
			while((len=is.read(buff))!=-1) {
				sb.append(new String(buff,0,len));
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
