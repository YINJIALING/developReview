package mulitthread;

import java.util.concurrent.atomic.AtomicInteger;

public class ViolatedDemo {
	private static AtomicInteger num=new AtomicInteger();
//	private volatile static boolean flag=true;

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				while(num.get()<=100) {
					if(num.get()%2!=0) {
						System.out.println(Thread.currentThread().getName()+" "+num.get());
						num.incrementAndGet();
//						flag=false;
					}
						
					
				}
				
			}
			
		});
		
		t1.setName("奇数");
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				while(num.get()<=100) {
					if(num.get()%2==0) {
						System.out.println(Thread.currentThread().getName()+" "+num.get());
						num.incrementAndGet();
//						flag=true;
					}
						
					
				}
				
			}
			
		});
		
		t2.setName("偶数");
		t1.start();
		t2.start();

	}

}
