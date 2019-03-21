package mulitthread;
/*
 * 一个线程打印奇数，一个线程打印偶数
 * https://www.cnblogs.com/study-everyday/p/6292738.html
 * printOdd拿到对象锁，进行更新，更新完通知PrintEven，进行更新，否则释放对象锁
 */
public class MainTest {

	public static void main(String[] args) {
		Num num1=new Num();
		PrintOdd printOdd=new PrintOdd(num1);
		PrintEven printEven=new PrintEven(num1);
		Thread thread1=new Thread(printOdd);
		Thread thread2=new Thread(printEven);
		thread1.start();
		thread2.start();
	}

}
