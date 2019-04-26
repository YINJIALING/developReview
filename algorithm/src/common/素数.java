package common;

public class 素数 {

	public static void main(String[] args) {
		boolean res=isPrime(3);
		System.out.println(res);
	}
	private static boolean isPrime(int n) {
		if(n<2)return false;
		for(int i=2;i<n;i++) {
			if(n%i==0)return false;//可以整除i
		}
		return true;
	}

}
