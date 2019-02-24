package 多线程.模拟存钱;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
public static void main(String[] args) {
	Account account=new Account();
	ExecutorService service=Executors.newFixedThreadPool(100);
	
	for(int i=1;i<=100;i++) {
		service.execute(new AddMoneyThread(account, 1));
	}
	service.shutdown();
	
	while(!service.isTerminated()) {}//等所有线程都停止了
	System.out.println("账户余额："+account.getBalance());//结果是2不是100
}
}
