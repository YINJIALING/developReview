package 多线程;
class Data{
	boolean flag=true;
}
class C implements Runnable{
	private Data data;

	public C(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		while(true) {
			synchronized(data) {
				if(data.flag)
					try {
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
					System.out.println("11111111C"+Thread.currentThread().getName());
					data.flag=true;
					data.notify();
				}
			}
		}
		
	}
	
}
class P implements Runnable{
	private Data data;

	public P(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		while(true) {
			synchronized(data) {
				if(!data.flag)
					try {
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
					System.out.println("111111111P"+Thread.currentThread().getName());
					data.flag=false;
					data.notify();
				}
			}
		}
		
		
	}
	
}
public class TestDemo  {


	public static void main(String[] args) {
		Data data=new Data();
		P p=new P(data);
		C c=new C(data);
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		t1.start();t2.start();
	
	}
	
}

