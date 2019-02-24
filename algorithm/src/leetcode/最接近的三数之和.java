package leetcode;

import java.util.Arrays;

public class 最接近的三数之和 {
	public static void main(String[] args) {
		int[] nums= {0,2,1,-3};
		int target=1;
		System.out.println(threeSumClosest(nums,target));
	}

	/**
	 * 同三数之和
	 * 需要注意的是：求sum与target相差有正有负，因而需要设置两个临时变量记录正值最小差值，负值最大差值。
	 * 结果返回的是：target与差值相减
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n=nums.length;
		int tempMax=Integer.MAX_VALUE;//正值最小差值
		int tempMin=Integer.MIN_VALUE;//负值最大差值
		int sum=0;
		for(int i=0;i<n-1;i++) {
			int left=i+1;
			int right=n-1;
			
			while(left<right) {
				sum=nums[i]+nums[left]+nums[right];
				if(sum>target) {
					tempMax=getMinOfTwo(tempMax,sum-target);
					right--;
				}else if(sum<target) {
					tempMin=getMaxOfTwo(tempMin,sum-target);
					left++;
				}else {
					return target;
				}
			}
			
			while(i<n-2&&nums[i]==nums[i+1]) {
				i++;
			}
		}
		if(tempMax==Integer.MAX_VALUE)
			return target+tempMin;
		if(tempMin==Integer.MIN_VALUE)
			return target+tempMax;
		if(tempMax<0-tempMin) {
			return target+tempMax;
		}else {
			return target+tempMin;
		}
		
	}
	
	private static int getMinOfTwo(int a,int b) {
		return a<b?a:b;
	}
	private static int getMaxOfTwo(int a,int b) {
		return a>b?a:b;
	}
}
