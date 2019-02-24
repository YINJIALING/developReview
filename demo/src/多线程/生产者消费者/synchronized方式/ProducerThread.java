package 多线程.生产者消费者.synchronized方式;
/**
 * 生产者线程
 * @author yinjialing
 *
 */
public class ProducerThread extends Thread{
	private Resource resource;

	public ProducerThread(Resource resource) {
		super();
		this.resource = resource;
	}
	
	@Override
	public void run() {//不断的生产资源
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resource.add();
		}
	}
}
