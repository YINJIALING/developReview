package xiaozhao2018;

import java.util.Scanner;

public class 内存条 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int l=in.nextInt();
		int r=in.nextInt();
		int w=in.nextInt();
		System.out.println(test(l,r,w));
	}

	/**
	 * 总容量-读的量>写的量
	 * @param l 总容量
	 * @param r 读的量
	 * @param w 写的量
	 * @return
	 */
	private static String test(int l, int r, int w) {
		if(r+w>l)return "DEADLOCK";
		else
			return "OK"; 
		
	}

}
