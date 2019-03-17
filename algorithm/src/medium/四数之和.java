package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import common.TestTools;
public class 四数之和 {

	public static void main(String[] args) {
		List<List<Integer>> res=fourSum(new int[]{1,0,-1,0,-2,2},0);
//		List<List<Integer>> res=fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0);
				
		TestTools t=new TestTools();
		t.print(res);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res=new ArrayList<>();
		Arrays.sort(nums);
		fourSumCore(res,new ArrayList<>(),target,nums,0,0);
		return res;
	}

	/**
	 * 递归；思路同组合之和
	 * @param res 当前所有结果集
	 * @param curList 当前结果集
	 * @param target 当前target
	 * @param nums
	 * @param i 开始索引
	 * @param count 计数器
	 */
	private static void fourSumCore(List<List<Integer>> res,List<Integer> curList,int target, int[] nums, int i, int count) {
		if(count==4&&target==0) {
			res.add(new ArrayList<>(curList));
			return ;
		}
		for(int j=i;j<nums.length;j++) {
			if(count!=4&&j<nums.length) {
				if(j>i&&nums[j]==nums[j-1])continue;//去重，因为题目中说不能有重复的四元组
				//如果i与j位上的值相同，结束本次循环，进行下次循环
				
				curList.add(nums[j]);
				fourSumCore(res,curList,target-nums[j],nums,j+1,count+1);
				curList.remove(curList.size()-1);
			}
		}	
	}

}
