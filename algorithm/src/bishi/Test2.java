package bishi;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int m=in.nextInt();
		if(m>=n)System.out.println(k);
		else {
			int res=(int)Math.ceil((double)n*k/m);
			System.out.println(res);
//			int res=k,diff=n-m;
//			while(diff>0) {
//				res+=k;
//				diff-=m;
//			}
//			System.out.println(res);
		}
		
	}
	

}
