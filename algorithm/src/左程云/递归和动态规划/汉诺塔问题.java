package 左程云.递归和动态规划;

public class 汉诺塔问题 {

	public static void main(String[] args) {
		hanoi(2);

	}
	/*
	 * 
	 */
	public static void hanoi(int n) {
		if(n>0)
			func(n,"left","mid","right");
	}
	private static void func(int n, String from, String mid, String to) {
		if(n==1)
			System.out.println("move from "+from+" to "+to);
		else {
			func(n-1,from,to,mid);
			func(1,from,mid,to);
			func(n-1,mid,from,to);
		}
	}

}
