package 多线程.生产者消费者.阻塞队列;
/**
 *  消费者线程
 * @author yinjialing
 *
 */
public class ConsumerThread extends Thread{
	private Resource resource;

	public ConsumerThread(Resource resource) {
		super();
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resource.remove();
		}
	}
}
