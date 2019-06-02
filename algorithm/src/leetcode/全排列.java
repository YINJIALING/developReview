package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://blog.csdn.net/u013309870/article/details/68941284
 * @author yinjialing
 *
 */
public class 全排列 {

	public static void main(String[] args) {
		List<List<Integer>> res=permute(new int[] {1,2,3});
//		for(List<Integer> tmp:res) {
//			System.out.print("{");
//			for(Integer index:tmp) {
//				System.out.print(index+",");
//			}
//			System.out.println("}");
//		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		int len=nums.length;
		List<List<Integer>> res=new ArrayList<>();
		core(res,0,len,nums);
		return res;
	}

	/**
	 *  1.如果 已经到了数组的最后一个元素，前面的元素已经排好输出
	 *  2.将第一个元素分别与后面的元素交换，递归的调用其子数组进行排序
	 * @param res
	 * @param start
	 * @param len
	 * @param nums
	 */
	private static void core(List<List<Integer>> res, int start, int len, int[] nums) {
			
		if(start>=len) {
			System.out.println(Arrays.toString(nums));
			return ;
		}
			
		for(int i=start;i<len;i++) {
			swap(i,start,nums);
			core(res,start+1,len,nums);
			swap(i,start,nums);
		}
	}

	private static void swap(int i, int start,int[] nums) {
		int tmp=nums[i];
		nums[i]=nums[start];
		nums[start]=tmp;
	}

}
