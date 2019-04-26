package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {

	public static void main(String[] args) {
		List<List<Integer>> res=subsets2(new int[] {1,2,3});
		for(List<Integer> list:res) {
			for(Integer index:list) {
				System.out.print(index+",");
			}
			System.out.println();
		}
	}

	/**
	 * 使用位运算
	 * i=0为100=4，i=1为10=2，i=2为1=1
	 * 集合 整数 i=0是否出现 i=1是否出现 i=2是否出现
	 * {} 000=0 000&100=0 000&010=0 000&001=0
	 * {3} 001=1 001&100=0 001&010=0 001&001=1
	 * {2} 010=2 010&100=0 010&010=1 010&001=0
	 * .........
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		//设置全部集合的最大值
		int all_set=1<<nums.length;//=2^nums.length
		for(int i=0;i<all_set;i++) { // i代表0-2^n-1这2^n个数
			List<Integer> item=new ArrayList<>();
			for(int j=0;j<nums.length;j++) {
				if((i&(1<<(nums.length-1-j)))!=0) //i&(1<<(nums.length-1-j))为真，代表nums[j]加入 item
					item.add(nums[j]);
			}
			res.add(item);
		}
		return res;

	}
	
	/**
	 * 递归+回溯
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		res.add(new ArrayList<>());//注意这里要添加一个空集
		subsetsCore(nums,res,new ArrayList<>(),0);
		return res;
	}

	 /**
	  * 对于nums[i]可以有放入和不放入
	  * 放入 继续递归
	  * 不放入 继续递归
	  * @param nums
	  * @param res
	  * @param arrayList
	  * @param i
	  */
	private static void subsetsCore(int[] nums, List<List<Integer>> res,List arrayList, int i) {
		if(i==nums.length)return ;
		arrayList.add(nums[i]);//使用nums[i]
		res.add(new ArrayList<>(arrayList));
		subsetsCore(nums,res,arrayList,i+1);//第一次递归
		arrayList.remove(arrayList.size()-1);//不使用nums[i]		
		subsetsCore(nums,res,arrayList,i+1);//第二次递归
	}

}
