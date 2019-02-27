package easy;

public class 阶乘后的零 {

	public static void main(String[] args) {
//		System.out.println(trailingZeroes(3));
//		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes2(7));
//		System.out.println(trailingZeroes(15));
	}

	public static int trailingZeroes(int n) {
		long res=1;
		if(n<=0)return 0;
		while(n!=1) {
			res*=n--;
		}
		System.out.println("res"+res);
		int count=0;
		if(res>=10&&res%10==0)count++;
		while(res!=0) {
			res/=10;
			if(res!=0&&res%10==0)
				count++;
		}
		return count;
	}
	public static int trailingZeroes2(int n) {
		 int ans = 0;
	     while(n >= 5) {
	         n /= 5;
	         ans += n;
	     }
	     return ans;
	}
	

}
