package 多线程.生产者消费者.阻塞队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressWarnings("unchecked")
public class Resource {
	private BlockingQueue resourceQueue = new LinkedBlockingQueue(10);

	// 向资源池中添加资源
	public void add() {
		try {
			resourceQueue.put(1);
			System.out.println(Thread.currentThread().getName() + " consumer 1 thread.There are " + resourceQueue.size()
					+ " threads");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 从资源池中取走资源
	public void remove() {
		try {
			resourceQueue.take();
			System.out.println("consumer:" + Thread.currentThread().getName() + "number -1 " + ".There are "
					+ resourceQueue.size() + " threads");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
