package 多线程.生产者消费者.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Resource {
	private int num=0;//当前资源数
	private final int size=10;//资源池中允许存放的资源数目
	private Lock lock;
	private Condition producerCondition;
	private Condition consumerCondition;
	
	
	public Resource(Lock lock, Condition producerCondition, Condition consumerCondition) {
		super();
		this.lock = lock;
		this.producerCondition = producerCondition;
		this.consumerCondition = consumerCondition;
	}

	//从资源池中取走资源
	public void remove() {
		lock.lock();
		try {
			if(num>0) {
				num--;
				System.out.println("consumer:"+Thread.currentThread().getName()+"number -1 "+".There are "+num+" threads");
				producerCondition.signalAll();//通知生产者生产资源
			}else {//资源池中没有资源数
				try {
					wait();//消费者进入等待状态
					System.out.println("consumer"+Thread.currentThread().getName()+" waiting");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}finally {
			lock.unlock();
		}
		
	}
	
	//向资源池中添加资源
	public void add() {
		lock.lock();
		try {
			if(num<size) {//可以添加
				num++;
				System.out.println(Thread.currentThread().getName()+" consumer 1 thread.There are "+num+" threads");
				consumerCondition.signalAll();//通知等待的消费者
			}else {
				try {
					producerCondition.await();//生产者进入等待，并释放锁
					System.out.println(Thread.currentThread().getName()+" waiting");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}finally {
			lock.unlock();
		}
		
	}
}
