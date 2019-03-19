package xiaozhao2018;

import java.util.Scanner;

public class bit位数 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int n=in.nextInt();
		System.out.println(test(m,n));
	}

	/**
	 * 计算两个数字异或的结果有多少个1
	 * @param m
	 * @param n
	 * @return
	 */
	private static int test(int m, int n) {
		int res=m^n;//异或
		String s=Integer.toBinaryString(res);//将十进制转为二进制字符串
		char[] c=s.toCharArray();
		int count=0;
		for(char tmp:c) {
			if(tmp=='1')count++;//计算里面有多少个1
		}
		return count;
	}
	
}
