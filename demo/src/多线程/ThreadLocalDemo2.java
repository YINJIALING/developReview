package 多线程;

public class ThreadLocalDemo2 {

	public static void main(String[] args) {
		Thread t1=new Thread(new MyRunnable(),"A");
		Thread t2=new Thread(new MyRunnable(),"A");
		t1.start();t2.start();
	}
}

class MyRunnable implements Runnable{

	private ThreadLocal<Integer> threadLocal=new ThreadLocal<>();	
	
	public MyRunnable() {//由主程序调用，set()在主线程的环境中完成的，只能由主线程get
		threadLocal.set((int) (Math.random()*100));	
		System.out.println(Thread.currentThread().getName()+":"+threadLocal.get()+ " from construct function");
	}

	@Override
	public void run() {//运行的是子线程，但是这里并没有使用set赋值，get到的是null
//		threadLocal.set((int) (Math.random()*100));	
		System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
		
	}
}
