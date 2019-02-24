package 多线程;

import java.util.concurrent.CountDownLatch;

public class countDownLatchDemo {
	private static final int worker=3;
public static void main(String[] args) {
	
	CountDownLatch countDownLatch=new CountDownLatch(worker);//初始值为3的到计数器
	new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("D is waiting for other three threads");
			try {
				countDownLatch.await();//检查计数器是否为0，不为0则保持等待状态
				System.out.println("all done.D starts working");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}).start();
	
	for(char threadName='a';threadName<='c';threadName++) {
		final String tN=String.valueOf(threadName);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(tN+" is working");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(tN+" finished");
				countDownLatch.countDown();
				//到计数器-1，当三个都运行完，计数器=0，触发D的await()运行结束，继续向下执行
			}
		}).start();
	}
}
}
