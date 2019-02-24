package 知识点;

public class 递归 {

	/**
	 * 斐波那契数列
	 */
	private int process(int n) {
		if(n<=1)return n;
		return process(n-1)+process(n-2);
	}
	/**
	 * 阶乘
	 * n! = n * (n-1)!
	 */
	private int process2(int n) {
		if(n<=1)return 1;
		return process2(n-1)*n;
	}
}
