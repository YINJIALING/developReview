package 多线程.模拟存钱;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.breakyizhan.com/javamianshiti/2459.html
 * @author yinjialing
 *
 */
public class Account {
	private Lock accountLock=new ReentrantLock();//第3种方案：为每个账户创建一个锁对象，存钱进行加锁和解锁
private double balance;//余额

/**
 * 存款操作
 * @param money
 * @throws InterruptedException 
 */
// 第一种调整方案：在存钱这个方法上加锁
// public synchronized void deposit(double money) throws InterruptedException {
//	 double newBalance=balance+money;
//	 Thread.sleep(10);//模拟
//	 balance=newBalance;
// }
public void deposit(double money) throws InterruptedException {
	accountLock.lock();
	try {
		double newBalance=balance+money;
		 Thread.sleep(10);//模拟
		 balance=newBalance;
	}finally {
		 accountLock.unlock();
	}
}
//public void deposit(double money) throws InterruptedException {
//	 double newBalance=balance+money;
//	 Thread.sleep(10);//模拟
//	 balance=newBalance;
//}
public double getBalance() {
	return balance;
}

//public void setBalance(double balance) {
//	this.balance = balance;
//}

}
