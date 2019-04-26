package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 字母异位词分组 {

	public static void main(String[] args) {
		List<List<String>> res=groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
		if(!res.isEmpty()) {
			for (List<String> list:res) {
				for(String str:list) {
					System.out.print(str+",");
				}
				System.out.println();
			}
		}
	}

	/**
	 * 1.遍历整个数组，记录每个字符串的单词出现次数，以及对应的字符串链表
	 * 2.遍历记录的结果，将字符串链表整理成答案返回
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res=new ArrayList<>();
		//k:单词的出现次数，v:对应的字符串链表
		Map<Map<Character,Integer>,List<String>> map=new HashMap<>();
		for(int i=0;i<strs.length;i++) {
			Map<Character,Integer> tmp=new HashMap<>();
			for(int j=0;j<strs[i].length();j++) {
				char c=strs[i].charAt(j);
				tmp.put(c, tmp.getOrDefault(c, 0)+1);
			}
			List<String> list=map.getOrDefault(tmp, new ArrayList<>());
			list.add(strs[i]);
			map.put(tmp, list);	
		}
		for(List<String> tmpList:map.values()) {
			res.add(tmpList);
		}
		return res;
	}

}
