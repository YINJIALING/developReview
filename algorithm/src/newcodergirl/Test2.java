package newcodergirl;

import java.util.Scanner;

public class Test2 {
	private static final int X_VALUE=5;

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input=in.nextInt();
        System.out.println(getRes(input));
    }
	private static int getRes(int input) {
		double res=0;
		for(int i=X_VALUE;i<input;i++) {
			res +=getF(input);
		}
		return (int) res;
	}
	private static double  getF(int input) {
		double max=Integer.MIN_VALUE;
		for(int i=1;i<=input;i++) {
			double tmp=Math.pow(input/i, i);
			max=max>tmp?max:tmp;
		}	
		return max;
	}
	
	
}
