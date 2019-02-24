package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

	public static void main(String[] args) {
		int[] num = { -1,0,1,2,-1,-4 };
		System.out.println(threeSum(num));
	}

	/**
	 * 1.先排序
	 * 2.遍历数组，两指针法，left是i+1处，right是nums.length-1处。令nums[i]+nums[left]+nums[right]=sum
	 * 3.sum>0大了，right--;sum<0小了，left++;sum==0,加入集合
	 * 注意：需要去重
	 * 
	 * 时间复杂度o(n^2)超时;修改为另外一种去重方法不超时了。可能每一次contains()都需要遍历一遍map
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<>();
		int n=nums.length;
		for(int i=0;i<n-2;i++) {	
			
			int left=i+1;
			int right=n-1;
			while(left<right) {
				List<Integer> list=new ArrayList<>();
				int sum=nums[i]+nums[left]+nums[right];
				if(sum>0)right--;
				else if(sum<0)left++;
				else {
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					res.add(list);
					//另外一种去重的方法：当nums[j]==nums[j+1]指针左移或右移
					while(left<right&&nums[left]==nums[left+1])left++;
					while(left<right&&nums[right]==nums[right-1])right--;
//					if(!res.contains(list))
//						res.add(list);//去重
					//break;//这里不能break的原因是，存在nums[i]+nums[left]+nums[right]=sum且nums[i]+nums[++left]+nums[--right]=sum
					left++;right--;
				}
			}
			
			while(nums[i]==nums[i+1]&&i+1<n-2) {
				i++;
			}
		}
		return res;
	}

}
