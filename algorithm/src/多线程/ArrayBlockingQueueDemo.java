package 多线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
	private final static ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(1); 

	public static void main(String[] args) {
		
		new Thread(new Producer(queue)).start();
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

}
class Consumer implements Runnable{
	private ArrayBlockingQueue<String> arrayBlockingQueue;

	public Consumer(ArrayBlockingQueue<String> arrayBlockingQueue) {
		this.arrayBlockingQueue = arrayBlockingQueue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	private void consume() throws InterruptedException {
		String str=arrayBlockingQueue.take();
		System.out.println("消费"+str);
		
	}
	
}
class Producer implements Runnable{
	private ArrayBlockingQueue<String> arrayBlockingQueue;

	public Producer(ArrayBlockingQueue<String> arrayBlockingQueue) {
		this.arrayBlockingQueue = arrayBlockingQueue;
	}

	@Override
	public void run() {
		while(true) {
			produce();
		}
		
	}

	private void produce() {
		String str="Producer";
		try {
			arrayBlockingQueue.put(str);
			System.out.println("生产"+str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
