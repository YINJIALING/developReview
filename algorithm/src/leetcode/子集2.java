package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 子集2 {

	public static void main(String[] args) {
		List<List<Integer>> res=subsetsWithDup(new int[] {1,2,2});
		for(List<Integer> list:res) {
			for(Integer index:list) {
				System.out.print(index+",");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> set=new HashSet<>();
		set.add(new ArrayList<>());//注意这里要添加一个空集
		subsetsWithDupCore(set,new ArrayList<>(),0,nums);
		List<List<Integer>> res=new ArrayList<>(set);
		return res;
	}

	private static void subsetsWithDupCore(Set<List<Integer>> set, List arrayList, int i, int[] nums) {
		if(i>=nums.length)
			return;
		arrayList.add(nums[i]);
		set.add(new ArrayList<>(arrayList));
		subsetsWithDupCore(set,arrayList,i+1,nums);
		arrayList.remove(arrayList.size()-1);
		subsetsWithDupCore(set,arrayList,i+1,nums);
	}

}
