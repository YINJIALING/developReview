package 剑指offer2;

public class 计算1到n {

	public static void main(String[] args) {
		int res1=cal(50,1,0);
		int res2=cal2(50);
		System.out.println(res1);
		System.out.println(res2);
	}
	

	private static int cal2(int i) {
		int index=1,count=0;
		while(index<i) {
			count+=index;index++;
		}
			
		return count;
	}


	private static int cal(int end,int start,int count) {
		if(start>=end)return count;
		count+=start;
		return cal(end,start+1,count);
	}
	

}
