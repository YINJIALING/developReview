package 多线程;

public class ThreadWaitAndNotify {
public static void main(String[] args) {
	Object lock=new Object();
	Thread a=new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("A等待lock");
			synchronized (lock) {
				System.out.println("A 1");
				try {
					System.out.println("A进入等待状态，放弃lock的控制");
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("有人唤醒了A,a重新获得lock");
				System.out.println("A 2");
				System.out.println("A 3");
			}
		}
		
	});
	Thread b=new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("B等待lock");
			synchronized (lock) {// 获得这个锁，才能操作
				System.out.println("B获得lock");
				System.out.println("B 1");
				System.out.println("B 2");
				System.out.println("B 3");
				System.out.println("B打印完毕，执行notify");
				lock.notify();
			}
		}
		
	});
	a.start();b.start();
}
}
