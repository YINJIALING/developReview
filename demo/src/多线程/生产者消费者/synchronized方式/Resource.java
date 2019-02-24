package 多线程.生产者消费者.synchronized方式;

public class Resource {
	private int num=0;//当前资源数
	private int size=10;//资源池中允许存放的资源数目
	
	//从资源池中取走资源
	public synchronized void remove() {
		if(num>0) {
			num--;
			System.out.println("consumer:"+Thread.currentThread().getName()+"number -1 "+".There are "+num+" threads");
			notifyAll();//通知生产者生产资源
		}else {//资源池中没有资源数
			try {
				wait();//消费者进入等待状态
				System.out.println("consumer"+Thread.currentThread().getName()+" waiting");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//向资源池中添加资源
	public synchronized void add() {
		if(num<size) {//可以添加
			num++;
			System.out.println(Thread.currentThread().getName()+" consumer 1 thread.There are "+num+" threads");
			notifyAll();//通知等待的消费者
		}else {
			try {
				wait();//生产者进入等待，并释放锁
				System.out.println(Thread.currentThread().getName()+" waiting");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
