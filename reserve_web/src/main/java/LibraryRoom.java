

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class LibraryRoom implements Runnable{
	
	private int temp;

	private static boolean isA = false;
	private static boolean isB = false;
	private static boolean isC = false;
	private static boolean isD = false;
	private static String a = ""; //A订到的房间号
	private static boolean isStart = false;
	private static boolean isPrepair = false;

	private static String date = "";
	private static String today = "";
	private static int interval = 1000; //慢�?�发请求的间�?
	private static int aheadSecond = 120; //提前aheadSecond秒开始慢速发请求
	private static String timeBegin = "20:59:15"; //�?始快速发请求时间
	private static int adheadDay = 2;

	private static void init() {
		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.add(Calendar.DATE, adheadDay);
		date = new SimpleDateFormat("yyyy-MM-dd").format(dateCalendar.getTime());
		today = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		long waitTime = new Date(today + " " + timeBegin).getTime() - aheadSecond * 1000;

		try {
			if (waitTime > System.currentTimeMillis())
				Thread.sleep(waitTime - System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	private static void wanglei() {
		Gson gson = new GsonBuilder().create();

		String prefix = "http://202.120.82.2:8081/ClientWeb/pro/ajax";

		Map head = new HashMap<String, String>();

		Map res = gson.fromJson(
				HttpRequest.sendHttpGet(prefix + "/login.aspx?id=51174500151&pwd=yh19950518&act=login", head),//用户名，密码
				Map.class);

		head.put("Cookie", "ASP.NET_SessionId=" + head.get("ASP.NET_SessionId"));
		head.remove("ASP.NET_SessionId");
	//411-415玻璃门	
//		final String Room411 = "3676604";
		final String Room412 = "3676641";
		final String Room413 = "3676645";
		final String Room414 = "3676656";
		final String Room415 = "3676664";
		final String Room421 = "3676503";
		final String Room422 = "3676511";
		final String Room423 = "3676515";
		final String Room424 = "3676522";
		final String Room425 = "3676538";
		final String Room426 = "3676547";
		final String Room427 = "3676566";
		final String Room428 = "3676574";
		final String Room429 = "3676580";
		
		final String applyRoom=Room412;

//		int i = 0;

		String room1 = applyRoom;
//		String room2 = Room415;
//		String room3 = Room423;
//		String room4 = Room424;
//		String room5 = Room425;
//		String room6 = Room426;
//		String room7 = Room427;
//		String room8 = Room428;
//		String room9 = Room429;
		seat(room1, gson, prefix, head);

	}
	
	private void runB(String roomNumber, Gson gson, String prefix, Map head) {
		if (!isB) {
			String b = gson
					.fromJson(
							HttpRequest.sendHttpGet(prefix + "/reserve.aspx?dev_id=" + roomNumber
									+ "&lab_id=3674920&kind_id=3674969&type=dev&prop=&test_id=&term=&test_name=&"
									+ "start=" + date + "+10%3A50&" + "end=" + date + "+13%3A40&" + "start_time=1050&"
									+ "end_time=1340" + "&up_file=&memo=&act=set_resv&_=1497964540852%20", head),
							Map.class)
					.get("msg").toString();
			System.out.println(roomNumber + "\tb\t" + b);
			isB = b.contains("成功");
			if (!isB)
				return;
		}
//		System.out.println("runB"+"\t"+roomNumber+"\t"+gson.toString()+"\t"+prefix+"\t");
	}
	
	private void runC(String roomNumber, Gson gson, String prefix, Map head) {
		if (!isC) {
			String c = gson
					.fromJson(
							HttpRequest.sendHttpGet(prefix + "/reserve.aspx?dev_id=" + roomNumber
									+ "&lab_id=3674920&kind_id=3674969&type=dev&prop=&test_id=&term=&test_name=&"
									+ "start=" + date + "+13%3A50&" + "end=" + date + "+17%3A40&" + "start_time=1350&"
									+ "end_time=1740" + "&up_file=&memo=&act=set_resv&_=1497964540852%20", head),
							Map.class)
					.get("msg").toString();
			System.out.println(roomNumber + "\tc\t" + c);
			isC = c.contains("成功");
			if (!isC)
				return;
		}
//		System.out.println("runc"+"\t"+roomNumber+"\t"+gson.toString()+"\t"+prefix+"\t");
	}
	private void runA(String roomNumber, Gson gson, String prefix, Map head) {
		if (!isA) {
			String a = gson
					.fromJson(
							HttpRequest.sendHttpGet(prefix + "/reserve.aspx?dev_id=" + roomNumber
									+ "&lab_id=3674920&kind_id=3674969&type=dev&prop=&test_id=&term=&test_name=&"
									+ "start=" + date + "+8%3A00&" + "end=" + date + "+10%3A40&" + "start_time=800&"
									+ "end_time=1040" + "&up_file=&memo=&act=set_resv&_=1497964540852%20", head),
							Map.class)
					.get("msg").toString();
			System.out.println(roomNumber + "\ta\t" + a);
			isA = a.contains("成功");
			
			if (!isA) {
				return;
			}
			a = roomNumber;
		}
//		System.out.println("runa"+"\t"+roomNumber+"\t"+gson.toString()+"\t"+prefix+"\t");
	}
	
	private void runD(String roomNumber, Gson gson, String prefix, Map head) {
		if (!isD) {
			String d = gson
					.fromJson(
							HttpRequest.sendHttpGet(prefix + "/reserve.aspx?dev_id=" + roomNumber
									+ "&lab_id=3674920&kind_id=3674969&type=dev&prop=&test_id=&term=&test_name=&"
									+ "start=" + date + "+17%3A50&" + "end=" + date + "+21%3A50&" + "start_time=1750&"
									+ "end_time=2150" + "&up_file=&memo=&act=set_resv&_=1497964540852%20", head),
							Map.class)
					.get("msg").toString();
			System.out.println(roomNumber + "\td\t" + d);
			isD = d.contains("成功");
		}
//		System.out.println("rund"+"\t"+roomNumber+"\t"+gson.toString()+"\t"+prefix+"\t");
	}
	private String roomNumber;
	private Gson gson;
	private String prefix;
	private Map head;
	

	public LibraryRoom(int temp, String roomNumber, Gson gson, String prefix, Map head) {
		super();
		this.temp = temp;
		this.roomNumber = roomNumber;
		this.gson = gson;
		this.prefix = prefix;
		this.head = head;
	}

	private static void seat(String roomNumber, Gson gson, String prefix, Map head) {
		ExecutorService executor=Executors.newFixedThreadPool(10);
		while(!isA||!isB||!isC||!isD) {
			if(!isA)
				executor.submit(new LibraryRoom(1,roomNumber,gson,prefix,head));
			
			if(!isB)
				executor.submit(new LibraryRoom(2,roomNumber,gson,prefix,head));
			
			if(!isC)
				executor.submit(new LibraryRoom(3,roomNumber,gson,prefix,head));
			
			if(!isD)
				executor.submit(new LibraryRoom(4,roomNumber,gson,prefix,head));
		}//跳出了这个循环，说明4个都已执行成功了
		
		//executor.shutdown();//终止前允许执行以前提交的任务
		executor.shutdownNow();//阻止等待任务启动并试图停止当前正在执行的任务
		if(executor.isShutdown())
			System.out.println("抢座结束");
	}
	static Date runTime=runDate();

	public static void main(String[] args) {
		while(true) {
			Date curD=new Date();
			
			if(runTime.compareTo(curD)<=0) {
				System.out.println("抢啊");
				init();
				wanglei();
			}else {
				System.out.println("等一会，还没到时间");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
				
		}

	}
	
	private static Date runDate() {
		Calendar c=Calendar.getInstance();
	 	c.set(Calendar.HOUR_OF_DAY, 20);
	 	c.set(Calendar.MINUTE, 59);
	 	c.set(Calendar.SECOND, 30);
	 	Date time=c.getTime();
	 	System.out.println("等到"+time+"再抢");
	 	return time;
	}
	


	public void run() {
		if(temp==1)runA(roomNumber,gson,prefix,head);
		if(temp==2)runB(roomNumber,gson,prefix,head);
		if(temp==3)runC(roomNumber,gson,prefix,head);
		if(temp==4)runD(roomNumber,gson,prefix,head);
		
	}

}
