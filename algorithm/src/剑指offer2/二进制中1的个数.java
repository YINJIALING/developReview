package 剑指offer2;

public class 二进制中1的个数 {

	public static void main(String[] args) {
		System.out.println(NumberOf12(9));

	}
	/**
	 * 将n与flag=1做与运算，1001&0001=1，count+1
	 * 将flag左移1位,1001&0010=0,count不变
	 * 将flag左移1位,1001&0100=0,count不变
	 * 将flag左移1位,1001&1000=1000,count+1
	 * @param n
	 * @return
	 */
	public static int NumberOf1(int n) {
		int count=0;
		int flag=1;
		while(flag!=0) {
			if((n&flag)!=0)
				count++;
			
			flag=flag<<1;
		}
		return count;
    }
	/**
	 * n=1001
	 * 1001-1=1000 1000^1001=1000 count+1;
	 * 1000-1=111 111^1000=000 count+1;
	 * 一个非零整数-1，如果他最后边有1，就是把最右边的1变成0，接着把后边的全变为1
	 * 把一个整数-1，并与原来的整数做异或，结果相当于把二进制的最后边的1变为0-》只需要统计可以做几次这样的操作即可(应用于很多二进制问题)
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf12(int n) {
		int count=0;
		while(n!=0) {
			count++;
			n=(n-1)&n;
		}
		return count;
	}

}
