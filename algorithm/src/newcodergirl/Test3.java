package newcodergirl;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr=new int[n];
        int i=0;
        while(in.hasNext()) {
        	arr[i]=in.nextInt();
        }
        int[] res=getLevel(arr);
        printRes(res);
    }

	private static void printRes(int[] res) {
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}

	private static int[] getLevel(int[] arr) {
		int[] res=new int[arr.length];
		
		return null;
	}
}
