package high;

public class Task implements Runnable{
	private final int i;

	public Task(int i) {
		super();
		this.i = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task"+ i+"start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("task"+ i+ "finish");
	}

	
}
