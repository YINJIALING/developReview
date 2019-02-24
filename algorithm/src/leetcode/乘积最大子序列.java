package leetcode;

public class 乘积最大子序列 {

	public static void main(String[] args) {
		int[] arr1= {2,3,-2,4};
		int[] arr2= {-2,0,-1};
		System.out.println(maxProduct(arr1));
		System.out.println(maxProduct(arr2));
	}

	/**
	 *  因为有正有负，所以需要保存最小值。如果只有正数，保持最大值即可
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		int numsLength=nums.length;
		int[] max=new int[numsLength];
		int[] min=new int[numsLength];
		int maxRes=nums[0];//返回值
		max[0]=nums[0];
		min[0]=nums[0];
		for(int i=1;i<numsLength;i++) {
			//三种情况：第三种：清空前面的从当前值开始
			max[i]=getMax(nums[i],max[i-1]*nums[i],min[i-1]*nums[i]);//最大值
			min[i]=getMin(nums[i],max[i-1]*nums[i],min[i-1]*nums[i]);//最小值
			maxRes=Math.max(max[i], maxRes);
			//最大值不一定是要到最后一位产生，有可能在中间，所以需要不断比较最大值，返回当前最大的就行
		}
		return maxRes;
	}
	
	private static int getMax(int a,int b,int c) {
		return Math.max(Math.max(a, b), c);
	}

	private static int getMin(int a,int b,int c) {
		return Math.min(Math.min(a, b), c);
	}
}
