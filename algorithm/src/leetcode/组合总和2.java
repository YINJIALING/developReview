package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 组合总和2 {

	public static void main(String[] args) {
		List<List<Integer>> res=combinationSum2(new int[] {10,1,2,7,6,1,5},8);
		for(List<Integer> list:res) {
			for(Integer index:list) {
				System.out.print(index+",");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Set<List<Integer>> set=new HashSet<>();
		Arrays.sort(candidates);
		combinationSum2Core(candidates,target,0,set,new ArrayList<>(),0);
		List<List<Integer>> res=new ArrayList<>(set);
		return res;
	}

	private static void combinationSum2Core(int[] candidates, int target, int sum, Set<List<Integer>> set,
			List arrayList, int i) {
		if(sum>target||i>=candidates.length)return ;//剪枝
		arrayList.add(candidates[i]);
		sum=sum+candidates[i];
		if(sum==target) {
			set.add(new ArrayList<>(arrayList));
		}
		combinationSum2Core(candidates,target,sum,set,arrayList,i+1);
		
		arrayList.remove(arrayList.size()-1);
		sum-=candidates[i];
		combinationSum2Core(candidates,target,sum,set,arrayList,i+1);	
		
	}

}
