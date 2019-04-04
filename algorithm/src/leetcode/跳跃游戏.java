package leetcode;

public class 跳跃游戏 {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] {2,3,1,1,4}));
		System.out.println(canJump(new int[] {3,2,1,0,4}));
	}

	/*
	 * dp[i]为true,取决于以下情况：
	 *    dp[i-1]为true&&nums[i-1]>=1
	 *    dp[i-2]为true&&nums[i-2]>=2
	 *    dp[i-3]为true&&nums[i-3]>=3
	 *    
	 *    等等，以此类推，可以得出
	 *    dp[i-n]为true&&nums[i-n]>=n(1<=n<=i)
	 */
	public static boolean canJump(int[] nums) {
		int len=nums.length;
		if(len==0)return false;
		if(len==1)return true;
		//设dp[i]是从0到i个数能否到达
		boolean[] dp=new boolean[len];
		dp[0]=true;//0到0，当然能到达
		for(int i=1;i<len;i++) {
			int n=1;
			while(n<=i) {
				boolean tmp=dp[i-n]&&(nums[i-n]>=n);
				dp[i]=(dp[i]==false?tmp:dp[i]);
				if(dp[i])break;//找到一个就够了，跳出循环
				n++;
			}
		}
		return dp[len-1];
	}

}
