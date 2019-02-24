package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 众数 {

	 public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] nums=new int[num];
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<num;i++) {
			nums[i]=sc.nextInt();
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		//遍历map
		int max=0;
		for(Integer key:map.keySet()) {
			if(max<map.get(key)) {
				max=map.get(key);
			}	
		}
		//根据max去map中找
		for(Integer key:map.keySet()) {
			if(max==map.get(key)) {
				System.out.println(key+" "+map.get(key));
			}	
		}
	 }
	 //from gh
	 private void solution2() {
		 Scanner sc = new Scanner(System.in);
	        int n, in;
	        Map<Integer, Integer> map = new HashMap<>();

	        n = sc.nextInt();
	        for (int i = 0; i < n; i++) {
	            in = sc.nextInt();
	            map.put(in, map.getOrDefault(in, 0) + 1);
	        }

	        List<Integer> ans = new ArrayList<>();
	        int maxTimes = 0;

	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if (entry.getValue() > maxTimes) {
	                // 如果出现次数比当前大
	                ans.clear();
	                maxTimes = entry.getValue();
	                ans.add(entry.getKey());
	            } else if (entry.getValue() == maxTimes) {
	                // 出现次数与当前最大一样
	                ans.add(entry.getKey());
	            }
	        }

	        ans.sort(new Comparator<Integer>() {
	            @Override
	            public int compare(Integer o1, Integer o2) {
	                return o1 - o2;
	            }
	        });

	        for (Integer inte : ans) {
	            System.out.println(inte + " " + maxTimes);
	        } 
	 }
	 
}
