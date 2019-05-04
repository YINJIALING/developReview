package leetcode;

public class 最大子序和 {

	public static void main(String[] args) {
		int[] arr= {-3,-1,-2};
		System.out.println(maxSubArray3(arr));
	}
	public static int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
        		dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
        }
        int max=dp[0];
        for(int i=1;i<nums.length;i++) {
        		if(max<dp[i])
        			max=dp[i];
        }

        	return max;
    }
	
	public static int maxSubArray2(int[] nums) {
		int max=nums[0];
		int sum=nums[0];
		for(int i=1;i<nums.length;i++) {
			if(sum<0)
				sum=nums[i];
			else 
				sum+=nums[i];
			if(sum>max)
				max=sum;
		}
		return max;
	}
	
	/**
	 * 1.先考虑贪心
	 * 发现nums={2，6，-5，4}先找最大的value：4,发现只能选一个4，但res=2+6=8
	 * 2.dp
	 * 设dp[i]是第i个字符结尾的最大子段和，肯定要包含nums[i]
	 * dp[i]=max(dp[i-1]+nums[i],nums[i])
	 * 连续是坐标，我一开始想的是递增
	 * 
	 * i最大不代表对应的dp[i]值最大
	 * @param nums
	 * @return
	 */
	public static int maxSubArray3(int[] nums) {
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		int max_res=dp[0];
		for(int i=1;i<nums.length;i++) {
			dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
			max_res=max_res>dp[i]?max_res:dp[i];
		}
		return max_res;
	}

}
