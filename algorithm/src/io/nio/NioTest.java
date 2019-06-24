package io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//使用nio对文件进行复制
public class NioTest {
	public static void main(String[] args) throws IOException {
		//1.把文件读出来，通过inputstream获得channel
		FileInputStream fileInputStream=new FileInputStream("filepath");
		FileChannel inChannel=fileInputStream.getChannel();
		//创建buffer
		ByteBuffer byteBuffer= ByteBuffer.allocate(1024);
		
		//把channel的data写入buffer,若读到末尾，则返回-1
		//channel.read(byteBuffer);
		
		//2.把数据写入到文件中
		//获得一个通道
		FileOutputStream fileOutputStream=new FileOutputStream("filepath");
		FileChannel outChannel=fileOutputStream.getChannel();
		while(true) {
			int eof=inChannel.read(byteBuffer);
			//若为-1，则表示已经读到末尾
			if(eof==-1)
				break;
			else {
				//把读模式改为写模式
				byteBuffer.flip();outChannel.write(byteBuffer);byteBuffer.clear();//清空缓冲区
				
			}
		}
	}
}
