package mulitthread;

public class PrintEven implements Runnable{
	Num num;
	

	public PrintEven(Num num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		while(num.i<=100) {
			synchronized(num) {
				if(num.flag)
					try {
						num.wait();//进入等待，并且释放当前占用的锁
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
					System.out.println("even:"+num.i);
					num.i++;
					num.flag=false;
					num.notify(); //唤醒等待
				}
			}
		}
		
	}

}
