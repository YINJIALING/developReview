package 多线程;

/*
 * https://www.jianshu.com/p/e29632593057
 */
public class ProceduercConsumerDemo {

	public static void main(String[] args) {
		Resource resource = new Resource();
		ConsumerThread consumerThread = new ConsumerThread(resource);
		ProducerThread producerThread = new ProducerThread(resource);
		Thread t0 = new Thread(consumerThread);
		Thread t1 = new Thread(consumerThread);
		Thread t2 = new Thread(producerThread);
		Thread t3 = new Thread(producerThread);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}

}

class ConsumerThread implements Runnable {
	private Resource resource;

	public ConsumerThread(Resource resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resource.remove();
		}

	}

}

class ProducerThread implements Runnable {
	private Resource resource;

	public ProducerThread(Resource resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resource.add();
		}

	}

}

class Resource {
	// 当前资源数
	private int num = 0;
	// 允许存放的资源数
	private int size = 10;

	// 生产
	public synchronized void add() {
		if (num == 0) {
			num++;
			System.out.println("生产" + Thread.currentThread());
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 消费
	public synchronized void remove() {
		if (num > 0) {
			num--;
			System.out.println("消费" + Thread.currentThread().getName());
			notify();// 通知生产
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
