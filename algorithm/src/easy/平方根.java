package easy;

public class 平方根 {

	public static void main(String[] args) {
		System.out.println(mySqrt(8));
	}

	public static int mySqrt(int x) {
		if(x<0)return 0;
		
		return (int) Math.sqrt(x);
	}

}
