package bishi;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		int[] arr=new int[T+1];
		for(int i=1;i<=T;i++) {
			arr[i]=in.nextInt();
		}
		for(int i=1;i<=T;i++) {
			System.out.println(cal(arr[i]));
		}
	}

	private static int cal(int i) {
		int count=0;
		while(i>1&&i<=1000) {
			if(i%2==0) {
				i=i/2;
				count++;
			}else {
				int tmp=3*i+1;
				if(tmp<=1000) {
					i=tmp;count++;
				}
				else {
					return -1;
				}
			}
		}
		if(i==1)return count;
		else
			return -1;
	}

}
