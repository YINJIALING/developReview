package medium;

// 完全背包
public class 完全平方数 {

	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
	public static int numSquares(int n) {
		int[] dp=new int[n+1];// 和等于i需要的最小完全平方数
		int sqrt,min,count;
		for(int i=0;i<=n;i++) {
			if(i<4)dp[i]=i;
			else {
				min=Integer.MAX_VALUE;
				for(sqrt=(int) Math.sqrt(i);sqrt>=1;sqrt--) {//从开方开始遍历，截止条件是=1要使最小，必选
					count=1+dp[i-sqrt*sqrt];// 组成i的最小完全平方数=1+dp[i-sqrt*sqrt]。1是sqrt的平方数，第二位是剩下的最小完全数
					if(count<min)min=count;// 更新最小值
				}
				dp[i]=min;
			}
		}

		return dp[n];
	}

//	private static int[] init(int[] nums) {
//		nums[0]=1;
//		if(nums.length>1) {
//			int i=1;
//			while(i<nums.length) {
//				nums[i]=(int) Math.pow(i+1, 2);
//				i++;
//			}
//		}
//		return nums;
//	}

}
