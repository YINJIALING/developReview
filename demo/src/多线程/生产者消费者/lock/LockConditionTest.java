package 多线程.生产者消费者.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition producerCondition = lock.newCondition();
		Condition consumerCondition = lock.newCondition();
		Resource resource = new Resource(lock, consumerCondition, consumerCondition);
		// 生产者线程
		ProducerThread p1 = new ProducerThread(resource);
		ProducerThread p2 = new ProducerThread(resource);
		ProducerThread p3 = new ProducerThread(resource);

		// 消费者线程
		ConsumerThread c1 = new ConsumerThread(resource);
		ConsumerThread c2 = new ConsumerThread(resource);
		ConsumerThread c3 = new ConsumerThread(resource);
		
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
	}
}
