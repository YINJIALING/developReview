package 多线程;

public class ThreadLocalDemo {
public static void main(String[] args) {
//ThreadLocal<String> localName=new ThreadLocal();
//localName.set("Alieen");
//System.out.println(localName.get());
	for(int i=0;i<2;i++) 
	new Thread(new Runnable() {
		private ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
		@Override
		public void run() {
			threadLocal.set((int) (Math.random()*100));	
			System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
		}
		
	}).start();;
}
}
