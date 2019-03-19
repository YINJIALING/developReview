package xiaozhao2018;

import java.util.Scanner;

public class 数字转换机 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		int A=in.nextInt();
		int B=in.nextInt();
		System.out.println(test(a,b,A,B));
	}
 
	/**
	 * 输入数字a后，无论期间怎样变换，那么最后的值A必定为flag1 * a + flag2的形式，
	 * 其中flag1 是2的倍数；若flag1*b+flag2 == B，那么可以正常完成变换
	 * @param a
	 * @param b
	 * @param A
	 * @param B
	 * @return
	 */
	private static int test(int a, int b, int A, int B) {
		int count=0;
		int flag1=A/a,flag2=A%a;//flag1是×2，flag2是取余
		if(flag1*b+flag2==B)return flag1+flag2%2;//TODO 为啥返回这个
		return -1;
	}
	
}
