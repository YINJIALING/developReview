package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {

	public static void main(String[] args) {
		List<List<Integer>> res=combinationSum(new int[] {2,3,6,7},7);
		for(List<Integer> list:res) {
			list.forEach(str->{
				  System.out.print(str+" ");
				 });
			System.out.println();
		}
	}
	/**
	 * 1.排序
	 * 2.递归
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> res=new ArrayList<>();
		 List<Integer> list=new ArrayList<>();
		 Arrays.sort(candidates);
	     combinationSumCore(res,0,0,list,candidates,target);
	     return res;
	   }

	 /**
	  * 递归式
	  * @param res 结果集
	  * @param sum 当前和
	  * @param index 遍历数组的索引
	  * @param list 当前累加的结果集
	  * @param arr 数组
	  * @param target 需要计算达到的和
	  * @return
	  */
	private static void combinationSumCore(List<List<Integer>> res, int sum, int index,List<Integer> list,int[] arr,int target) {
		//递归终止条件
		if(sum==target) {
			res.add(list);
			return;
		}
		
		for(int i=index;i<arr.length&&sum<target;i++) {
			List<Integer> tmp=new ArrayList<>(list);//深拷贝
			tmp.add(arr[i]);
			combinationSumCore(res,sum+arr[i],i,tmp,arr,target);//从i开始得到的是去重的答案，if(param2==index)得到的是未去重的答案
		}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       		
	}

}
