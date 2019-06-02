package 多线程;

public class ResourceByConditionDemo {

	public static void main(String[] args) {
		ResourceByCondition r=new ResourceByCondition();
		ProducerThread pro=new ProducerThread(r);
		ConsumerThread con=new ConsumerThread(r);
		//2个生产者线程
		Thread t0=new Thread(pro);
		Thread t1=new Thread(pro);
		//2个消费者线程
		Thread t2=new Thread(con);
		Thread t3=new Thread(con);
		t0.start();t1.start();t2.start();t3.start();
	}

}
/**
 * 
 * @author yinjialing
 * 生产者
 * 一直生产
 */
class ProducerThread implements Runnable{
	private ResourceByCondition r;

	public ProducerThread(ResourceByCondition r) {
		super();
		this.r = r;
	}
	public void run() {
		while(true) {
			r.product("生产");
		}
	}
}
/**
 * 消费者
 * 一直消费
 * @author yinjialing
 *
 */
class ConsumerThread implements Runnable{
	private ResourceByCondition r;

	public ConsumerThread(ResourceByCondition r) {
		super();
		this.r = r;
	}
	public void run() {
		while(true) {
			r.consume();
		}
	}
}