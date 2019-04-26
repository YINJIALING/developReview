package 剑指offer2;

public class 变态跳台阶 {

	public static void main(String[] args) {
		System.out.println(JumpFloorII3
				(3));
		System.out.println(JumpFloorII
				(3));
		System.out.println(JumpFloorII2
				(3));
	}

	// 1,递归
	public static int JumpFloorII(int target) {
		if (target == 0)
			return 1;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		int res = 0;
		for (int i = 0; i < target; i++) {
			res += JumpFloorII(i);
		}

		return res;
	}

	//使用一个数组存之前的结果
	public static int JumpFloorII2(int target) {
		if (target == 0)
			return 1;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		
		int[] dp=new int[target+1];
		dp[0]=1;dp[1]=1;dp[2]=2;
		for(int i=3;i<=target;i++) {
			int start=i;
			while(start>=0) {
				dp[i]+=dp[start];
				start--;
			}
			
		}
		return dp[target];
	}
	/*
	 * f(n)=f(n-1)+f(n-2)+.....+f(1)
	 * f(n-1)=f(n-2)+.....+f(1)
	 * 因此f(n)=2f(n-1)
	 */
	public static int JumpFloorII3(int target) {
		if (target == 0)
			return 0;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		
		int[] dp=new int[target+1];
		dp[1]=1;dp[2]=2;
		for(int i=3;i<=target;i++) {
			dp[i]=2*dp[i-1];
		}
		return dp[target];
	}

}
