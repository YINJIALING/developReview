package 多线程;

public class 对象锁 {

	public static void main(String[] args) throws InterruptedException {
		Object lock=new Object();
		Thread A=new Thread(new Runnable() {

			@Override
			public void run() {
				int sum=0;
				for(int i=0;i<10;i++) {
					sum+=i;
				}
				synchronized(lock) {
					try {
						lock.wait();//阻塞
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("sum"+sum);
			}
		});
		A.start();
		System.out.println("sleep--------");
		Thread.sleep(2000);
		synchronized(lock) {
			lock.notify();//唤醒lock，需要与synchronized配合使用
		}
		
	}

}
