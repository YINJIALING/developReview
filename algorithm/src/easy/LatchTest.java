package easy;

import java.util.concurrent.CountDownLatch;

public class LatchTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runnable taskTemp=new Runnable() {
			private  int count;//使用volatile貌似还是没什么用

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++) {
					count++;
					System.out.println(System.nanoTime()+"模拟发请求"+Thread.currentThread().getName()+"count:"+count);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		};
		
		LatchTest latchTest=new LatchTest();
		latchTest.startTaskAllInOnce(5,taskTemp);
	}

	/***
	 * @param threadNums  线程数
	 * @param task 线程
	 * @throws InterruptedException 
	 * */
	private long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
		CountDownLatch startGate=new CountDownLatch(1);
		CountDownLatch endGate=new CountDownLatch(threadNums);
		for(int i=0;i<threadNums;i++) {
			Thread t=new Thread() {
				public void run() {
					//等待门打开
					try {
						startGate.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try{
						task.run();
					}finally {
						endGate.countDown();
					}
					//将结束门-1，=0时可以开启结束门
					
				}
			};
			t.start();
		}
		long startTime=System.nanoTime();
		System.out.println(startTime+"\t"+Thread.currentThread()+"准备好");
		//开启开始门
		startGate.countDown();
		//等结束门开启
		endGate.await();
		long endTime=System.nanoTime();
		System.out.println(endTime+"\t"+Thread.currentThread()+ "end");
		return endTime-startTime;
	}

}
