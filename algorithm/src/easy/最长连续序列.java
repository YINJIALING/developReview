package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长连续序列 {

	public static void main(String[] args) {
		int[] nums= {100,4,400,1,3,2};
		int res=longestConsecutive(nums);
		System.out.println(res);
	}
public static int longestConsecutive(int[] nums) {
	int max=0;
	Set<Integer> set=new HashSet<>();
	for(int i:nums) set.add(i);
	for(int i:nums) {
		if(!set.contains(i-1)) {
			int val=i;
			while(set.remove(val++));
			max=Math.max(max, val-i-1);
		}
	}
	return max;
}
//	Map<Integer,Integer> map=new HashMap<>();
//    int max=0;
//    for(int i=0;i<nums.length;i++) {
//   	 if(!map.containsKey(nums[i])) {
//   		 int left=map.getOrDefault(nums[i]-1,0);
//   		 int right=map.getOrDefault(nums[i]+1,0);
//   		 map.put(nums[i], left+right+1);
//            if(left!=0)
//                 map.put(nums[i]-left, left+right+1);
//
//            if(right!=0)
//                map.put(nums[i]+right, left+right+1);
//   		 max=max<map.getOrDefault(nums[i],0)?map.getOrDefault(nums[i],0):max;
//   	 } 
//    }
//    //return max;
//     return max;
//    }

}
