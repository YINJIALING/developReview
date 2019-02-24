package tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
 /**
  * https://blog.csdn.net/baidu_24545901/article/details/79118048
  * */
public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket client=null;
		try {
			serverSocket=new ServerSocket(8888);
			System.out.println("服务器初始化完毕，端口号是8888");
			while(true) {
				client=serverSocket.accept();
				InputStream in=(InputStream) client.getInputStream();
				byte[] buff=new byte[1024];
				int len=in.read(buff);		
				if(len>0) {
					String msg=new String(buff,0, len);
					System.out.println("客户端请求信息！"+msg);
					OutputStream os=client.getOutputStream();
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					StringBuffer sb=new StringBuffer();
					//请求头信息
					sb.append("http/1.1 200 OK\n");
					sb.append("Content-Type:text/html;charset=UTF-8\n");
					sb.append("cahce-control:max-age-0");
					sb.append("Upgrade-Insecure-Requests:1");
					sb.append("User-Agent:Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
					sb.append("Accept-Encoding:gzip, deflate, br");
					sb.append("Accept-Language:zh-CN,zh;q=0.9");
					sb.append("\r\n");
					
					//响应正文
					String html="<html><head><title>welcome</title></head><body>welcome!!!</body></html>";
					sb.append(html);//为啥要把响应头和正文连在一起？
					//响应业务
					os.write(sb.toString().getBytes());
					os.flush();
					os.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
