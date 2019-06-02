package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/javazejian/article/details/75043422
 * @author yinjialing
 * 一个锁有多个等待队列
 *
 */
public class ResourceByCondition {
	private String name;
	private int count=1;
	// true：烤鸭生成完毕，false：消费完毕
	private boolean flag=true;
	Lock lock=new ReentrantLock();
	
	//监视器--监视生产者
	Condition producer_con=lock.newCondition();
	//监视器--监视消费者
	Condition consumer_con=lock.newCondition();
	
	//当flag为true，表示烤鸭生成完成，那么就让监视生产者的监视器进入等待队列
	//否则，生产一个烤鸭，将flag设置为true，并唤醒消费者
	public void product(String name) {
		lock.lock();
		try {
			while(flag)
				try {
					producer_con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			this.name=name+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"-生产者-"+this.name);
			flag=true;
			
			//唤醒消费者
			consumer_con.signal();
		}finally {
			lock.unlock();
		}
		
	}
	
	//当flag为false，表示没烤鸭，那么就让监视消费者的监视器进入等待队列
	//否则，消费一个烤鸭，将flag设置为false，并唤醒生产者
	public void consume() {
		lock.lock();
		try {
			while(!flag)
				try {
					consumer_con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			System.out.println(Thread.currentThread().getName()+"-生产者-"+this.name);
			flag=false;
			
			//唤醒生产者
			producer_con.signal();
		}finally {
			lock.unlock();
		}
	}
	

}
