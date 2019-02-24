package 多线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest2 {

	public static void main(String[] args) {
		ThreadPoolExecutor pool=new ThreadPoolExecutor(
				5,//考虑如何根据实际业务设置corePoolSize
				Runtime.getRuntime().availableProcessors()*2,// 根据本机内核设置 maxPoolSize
				60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(200),
				new ThreadFactory() {//可以给线程进行一些特殊的设置
					@Override
					public Thread newThread(Runnable r) {
						Thread thread=new Thread(r);
						thread.setName("order-thread");
						if(thread.isDaemon())//是否是守护线程
							thread.setDaemon(false);
						//守护线程将会一直保持
						
						if(Thread.NORM_PRIORITY!=thread.getPriority())
							thread.setPriority(Thread.NORM_PRIORITY);
						return thread;
					}
				});
	}

}
