package leetcode;

public class 最大子序和 {

	public static void main(String[] args) {
		int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray2(arr));
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

}
