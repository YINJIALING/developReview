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

	private static void core(List<List<Integer>> res, int start, int len, int[] nums) {
//		if(start==len-1)
			System.out.println(Arrays.toString(nums));
		if(start>=len)
			return ;
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
