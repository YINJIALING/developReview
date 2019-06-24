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
	for(int i:nums) set.add(i);//先把所有的数都增加到set中
	for(int i:nums) {
		if(!set.contains(i-1)) {//如果set不包含i-1的元素
			int val=i;
			while(set.remove(val++));//直到成功
			max=Math.max(max, val-i-1);
		}
	}
	return max;
}

}
