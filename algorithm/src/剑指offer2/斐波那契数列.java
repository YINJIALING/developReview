package 剑指offer2;
/**
 * 
 * f(n)=0 n=0
 * f(n)=1 n=1
 * f(n)=f(n-1)+f(n-2) n>1
 * @author yinjialing
 *
 */
public class 斐波那契数列 {

	public static void main(String[] args) {
		System.out.println(Fibonacci2(4));
	}
	//1.递归
	public static int Fibonacci(int n) {
		if(n==0)return 0;
		if(n==1)return 1;
		return Fibonacci(n-1)+Fibonacci(n-2);
    }
	//2.非递归
	public static int Fibonacci2(int n) {
		int[] res= {0,1};
		if(n<2)return res[n];
		int fibNMinusOne=1,fibNMinusTwo=0,fibN=0;
		for(int i=2;i<=n;i++) {
			fibN=fibNMinusOne+fibNMinusTwo;
			fibNMinusTwo=fibNMinusOne;
			fibNMinusOne=fibN;
		}
		return fibN;
    }
}
