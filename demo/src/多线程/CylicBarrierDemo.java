package 多线程;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CylicBarrierDemo {
	private final static int RUNNER=3;
public static void main(String[] args) {
	CyclicBarrier cylicBarrier=new CyclicBarrier(RUNNER);//初始值3
	Random random=new Random();
	for(char threadName='a';threadName<='c';threadName++) {
		final String tN=String.valueOf(threadName);
		new Thread(new Runnable() {
			@Override
			public void run() {
				long prepareTime=random.nextInt(1000)+100;
				System.out.println(tN+" is preparing for time : "+prepareTime);
				try {
					Thread.sleep(prepareTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(tN+" is prepared ,waiting for others");
				try {
					cylicBarrier.await();//-1，当前线程准备完毕，等待别人准备好
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(tN+" starts running");//所有线程都准备好了
			}
		}).start();
	}
}
}
