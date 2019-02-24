package 多线程;
//b等a先完成再进行
public class ThreadJoinDemo {
public static void main(String[] args) {
	Thread a=new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				printNumber(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	});
	Thread b=new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("B等A");
			try {
				a.join();
				printNumber(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	});
	b.start();a.start();
}

private static void printNumber(String threadname) throws InterruptedException {
	int i=0;
	while(i++<3) {
		Thread.sleep(200);
		System.out.println("name:"+threadname+" print "+i);
	}
}
}
