package easy;

import java.util.HashMap;
import java.util.Map;

public class 求众数 {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {3,2,3}));
	}

	public static int majorityElement(int[] nums) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i:nums) {
			map.put(i,1+map.getOrDefault(i, 0));	
		}
		for(Integer key:map.keySet()) {
			if(map.get(key)>(nums.length>>1))
				return key;
		}
		return Integer.MAX_VALUE;
	}

}
