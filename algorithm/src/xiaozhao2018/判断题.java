package xiaozhao2018;

import java.util.Scanner;

/**
 * 假设他猜的题都答对，这样可以获得最高分
 * @author YJL
 *
 */
public class 判断题 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int t=in.nextInt();
		int a=in.nextInt();
		System.out.println(test(n,t,a));
	}

	/**
	 * 满分是n,总成绩=n-(答错的题目)
	 * @param n
	 * @param t
	 * @param a
	 * @return
	 */
	private static int test(int n, int t, int a) {
		return n-Math.abs(a-t);//绝对值
		
	}

}
