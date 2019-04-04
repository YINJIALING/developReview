package medium;

import java.util.ArrayList;
import java.util.List;

public class 计算右侧小于当前元素的个数 {

	public static void main(String[] args) {
		print(countSmaller(new int[] {5,2,6,1}));

	}

	private static void print(List<Integer> countSmaller) {
		for(Integer index:countSmaller)
			System.out.print(index+" ");
	}

	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> list=new ArrayList<>();
		if(nums.length==0)return list;
		int count;
		for(int i=0;i<nums.length-1;i++) {
			count=0;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]<nums[i])count++;
			}
			list.add(count);
		}
		list.add(0);
		return list;
	}

}
