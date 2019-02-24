package 多线程.模拟存钱;
//存钱线程
public class AddMoneyThread implements Runnable{
	private Account account;//存入账户
	 private double money;//存入金额

	public AddMoneyThread(Account account, double money) {
		super();
		this.account = account;
		this.money = money;
	}


	@Override
	public void run() {
		 try {
//			synchronized (account) {//第2种调整方案，对银行账户进行同步
				account.deposit(money);
//			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
