package leetcode;

public class 打家劫舍 {

	public static void main(String[] args) {
		int[] arr1= {1,2,3,1};
		int[] arr2= {2,7,9,3,1};
		System.out.println(rob(arr1));
		System.out.println(rob(arr2));
	}

	public static int rob(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int n=nums.length;
		if(n==1)return nums[0];
		int[] dp=new int[n];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);//重要
		int max=dp[1];
		for(int i=2;i<n;i++) {//抢这家或者不抢这家
			dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
			max=dp[i]>max?dp[i]:max;
		}
		return max;
	}

}
