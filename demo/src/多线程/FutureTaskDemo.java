package 多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	Callable<Integer> callable=new Callable<Integer>() {
		@Override
		public Integer call() throws Exception {
			System.out.println("task starts");
			Thread.sleep(1000);
			int res=0;
			for(int i=0;i<=100;i++) {
				res+=i;
			}
			System.out.println("task finished and return res");
			return res;
		}
	};
	FutureTask<Integer> futureTask=new FutureTask<>(callable);
	new Thread(futureTask).start();
	System.out.println("Before futureTask.get()");
	System.out.println("result:"+futureTask.get());
	//阻塞主线程，执行callable内部，并返回计算结果；此时futureTask.get()得到结果，主线程恢复运行
	System.out.println("After futureTask.get()");
}
}
