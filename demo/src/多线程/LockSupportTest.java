package 多线程;

import java.util.concurrent.locks.LockSupport;
//基于线程的锁
public class LockSupportTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread A=new Thread(new Runnable() {

			@Override
			public void run() {
				int sum=0;
				for(int i=0;i<10;i++) {
					sum+=i;
				}
				LockSupport.park();//阻塞
				System.out.println("sum"+sum);
			}
		});
		A.start();
		System.out.println("sleep--------");
		Thread.sleep(2000);
		LockSupport.unpark(A);//唤醒
		/**
		 *  非常灵活，不用写synchoronized；无须纠结先唤醒还是先阻塞
		 */
	}

}
