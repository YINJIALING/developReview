package 剑指offer2;

public class 改变m成为n {

	public static void main(String[] args) {
		System.out.println(changemTon(10,13));

	}
	/**
	 * 1.求m与n的异或
	 * 2.计算异或中1的个数
	 * @param m
	 * @param n
	 * @return
	 */
	private static int changemTon(int m,int n) {
		int tmp=m^n;
		int count=0;
		int flag=1;
		while(flag!=0) {
			if((n&flag)!=0)
				count++;
			flag=flag<<1;
		}
		return count;
	}
	

}
