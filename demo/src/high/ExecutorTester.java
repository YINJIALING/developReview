package high;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTester {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor=Executors.newFixedThreadPool(3);//线程数量不会增长
		List<Future<?>> taskResults=new LinkedList<>();
		for(int i=0;i<10;i++) {//10个任务
			taskResults.add(executor.submit(new Task(i)));
			//Future<?> task=executor.submit(new Task(i));//callable有返回值，runable无返回值
		}
//		System.out.println("10 tasks success given");
//		
//		for(Future<?> taskResult:taskResults) {
//			taskResult.get();//等待task的结束
//		}
		//不用future也可以，因为shutdown会等待所有已分发的完成，未分发的关闭
		//但是future可以检查任务的完成等其他操作
		System.out.println("all tasks finish");
		executor.shutdown();
	}
}
