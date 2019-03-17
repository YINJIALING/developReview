package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {

	public static void main(String[] args) {
		subsets(new int[] {1,2,3});
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			res.add(Arrays.asList(nums[i]));
			int j=i+1;
			while(j<nums.length) {
				
			}
		}
		return null;

	}

}
