package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合之和2 {

	public static void main(String[] args) {
		List<List<Integer>> res=combinationSum2(new int[] {10,1,2,7,6,1,5},8);
		for(List<Integer> list:res) {
			list.forEach(str->{
				  System.out.print(str+" ");
				 });
			System.out.println();
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res=new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum2Core(res,new ArrayList<>(),target,0,candidates,0);
		return res;
	}

	/**
	 * 
	 * @param res 所有排列的结果集
	 * @param arrayList 当前结果集
	 * @param target 目标和
	 * @param sum 当前和
	 * @param candidates 待计算数组
	 * @param index 当前数组索引
	 */
	private static void combinationSum2Core(List<List<Integer>> res, List<Integer> arrayList, int target, int sum,int[] candidates,int index) {
		if(sum==target)res.add(new ArrayList<>(arrayList));
		for(int i=index;i<candidates.length&&sum<target;i++) {
			if (i > index && candidates[i] == candidates[i-1]) continue; //去重操作
			arrayList.add(candidates[i]);
			combinationSum2Core(res,arrayList,target,sum+candidates[i],candidates,i+1);
			
			arrayList.remove(arrayList.size()-1);//移除最后一个的数据，将arrayList其他元素代入该循环，继续比较
			
		}
	}

}
