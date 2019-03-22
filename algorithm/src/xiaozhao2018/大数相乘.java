package xiaozhao2018;

import java.util.Scanner;

/**
 * https://blog.csdn.net/jinyongqing/article/details/13508577
 * @author yinjialing
 *
 */
public class 大数相乘 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String num1Str=sc.next();
		String num2Str=sc.next();
		int[] num1=new int[num1Str.length()];
		int[] num2=new int[num2Str.length()];
		//将字符串转为整数数组，如24566转为(6,6,5,4,2)
		for(int i=0;i<num1Str.length();i++) {
			num1[num1Str.length()-1-i]=num1Str.charAt(i)-'0';
		}
		for(int i=0;i<num2Str.length();i++) {
			num2[num2Str.length()-1-i]=num2Str.charAt(i)-'0';
		}
		int[] result=multiply(num1,num2);
		
		
		StringBuffer str=new StringBuffer();
		for(int i=result.length-1;i>=0;i--) {
			str.append(result[i]);	
		}
		String res=null;
		//去前几位的0
		char[] c=str.toString().toCharArray();
		for(int i=0;i<c.length;i++) {
			if(c[i]=='0') res=str.substring(i+1);
			else
				break;
		}
		if(res==null) {
			for(int i=0;i<c.length;i++) {
				System.out.print(c[i]);
			}
			System.out.println();
		}else {
			System.out.println(res);
		}
		
	}

	private static int[] multiply(int[] num1, int[] num2) {
		int lenthOfNum1=num1.length;
		int lenthOfNum2=num2.length;
		//分配一个空间，用来存计算的结果，n1长的数*n2长的数, 结果不会超过n1+n2长
		int[] result=new int[lenthOfNum1+lenthOfNum2];
		//先不考虑进位，根据小学竖式乘法运算，n1的第i位与n2的第j位相乘，结果应该存放在结果的第i+j位上
		for(int i=0;i<lenthOfNum1;i++) {
			for(int j=0;j<lenthOfNum2;j++) {
				result[i+j]+=num1[i]*num2[j];
			}
		}
		//单独处理进位问题
		for(int i=0;i<lenthOfNum1+lenthOfNum2-1;i++) {
			if(result[i]>10) {
				result[i+1]+=result[i]/10;
				result[i]%=10;
			}
		}

		return result;
	}

}
