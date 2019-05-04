package 剑指offer2;

import java.util.Arrays;

public class 打印从1到最大n的n位数 {

	public static void main(String[] args) {
		print(3);

	}
	/**
	 * 
	 * @param n
	 */
	private static void print2(int n) {
		if(n<=0)return ;
		char[] number=new char[n+1];
		Arrays.fill(number, '0');
		number[n]='0';
		for(int i=0;i<10;++i) {
			number[0]=(char) (i+'0');
			print1ToMax(number,n,0);
		}
	}
	private static void print1ToMax(char[] number, int length, int index) {
		if(index==length-1) {
			printNumber(number,n+1);
		}
		
	}
	/**
	 * 用一个数组表示当前数，为了防止特别大的情况
	 * 模拟加1操作
	 * @param n
	 */
	private static void print(int n) {
		if(n<=0)return ;
		char[] number=new char[n+1];
		Arrays.fill(number, '0');
		number[n]='0';
		while(!Increment(number,n+1)) {
			printNumber(number,n+1);
		}
		number[n]='9';
	}
	/**
	 * 打印数组
	 * 从第一个非0的位置开始
	 * @param number
	 * @param nLength
	 */
	private static void printNumber(char[] number,int nLength) {
		boolean isBeginning0=false;
		for(int i=0;i<nLength;i++) {
			if(number[i]!='0'&&!isBeginning0) {
				isBeginning0=true;
				System.out.print(number[i]);
			}			
		}
		System.out.print(",");
		
	}
	private static boolean Increment(char[] number,int nLength) {
		boolean isOverflow=false;
		int nTakeOver=0;
		for(int i=nLength-1;i>=0;i--) {
//			System.out.print("i:"+i);
			int nSum=number[i]-'0'+nTakeOver;

			if(i==nLength-1&&nSum==0)number[i]='1';
			if(i==0&&nSum==10) {
				return true;
			}else if(nSum==9){
				nTakeOver=1;
			}else if(nSum==10) {
				number[i]='0';
			}else {
				number[i]=(char) ('1'+nSum);
			}
				
		}
		return isOverflow;
	}

}
