package mulitthread;

public class PrintOdd implements Runnable{
	Num num;

	
	public PrintOdd(Num num) {
		super();
		this.num = num;
	}


	@Override
	public void run() {
		while(num.i<=100) {
			synchronized(num) {
				if(!num.flag) 
				
					try {
						num.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
					System.out.println("odd:"+num.i);
					num.i++;
					num.flag=true;
					num.notify();
				}
				
			}
		}
	}

}
