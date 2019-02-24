package deadlineNewYear;

public class 求和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Sum_Solution(100));
	}

	/**
	 * 等差数列求和公式s=(1+n)*n/2=(n+n^2)/2
	 * @param n
	 * @return
	 */
	public static int Sum_Solution(int n) {
		return (int)(Math.pow(n, 2)+n)>>1;
	}

}
