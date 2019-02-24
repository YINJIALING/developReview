package 多线程;
/**
 * InheritableThreadLocal 可以允许线程及该创建的子线程均可以访问同一个变量(类似于oop的protected)
 * @author yinjialing
 *
 */
public class InheritableThreadLocalDemo {
	private static InheritableThreadLocal<Integer> threadLocal=
			new InheritableThreadLocal<>();
	
	public static class MyRunnable implements Runnable{
		private String _name="";
		
		public MyRunnable(String name) {
			this._name = name;
			System.out.println(name+" -> "+Thread.currentThread().getName()+" : "
			+threadLocal.get());
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
		}
	}
	public static void main(String[] args) {//三个线程均这次正常get到了1
		threadLocal.set(1);
		System.out.println(Thread.currentThread().getName()+" : "+threadLocal.get());
		Thread t1=new Thread(new MyRunnable("R-A"),"A");
		Thread t2=new Thread(new MyRunnable("R-A"),"A");
		t1.start();t2.start();
	}

}
