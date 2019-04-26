package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {

	public static void main(String[] args) {
		List<String> res=letterCombinations("999");
		for(String index:res)
			System.out.print(index+",");
	}
	//电话字典
	static Map<Character,List<Character>> map=new HashMap<>();
	
	//递归
	public static List<String> letterCombinations(String digits) {
		if(digits==null||digits.length()==0)return new ArrayList<>();
		map.put('2',Arrays.asList('a','b','c'));
		map.put('3',Arrays.asList('d','e','f'));
		map.put('4',Arrays.asList('g','h','i'));
		map.put('5',Arrays.asList('j','k','l'));
		map.put('6',Arrays.asList('m','n','o'));
		map.put('7',Arrays.asList('p','q','r','s'));
		map.put('8',Arrays.asList('t','u','v'));
		map.put('9',Arrays.asList('w','x','y','z'));
		
		int len=digits.length();
		List<List<Character>> tmp=new ArrayList<>();
		core(tmp,new ArrayList<>(),len,digits,0);
		List<String> res=new ArrayList<>();
		for(List<Character> list:tmp) {
			int index=0;
			StringBuffer str=new StringBuffer();
			while(index<len) {
				str.append(list.get(index));
				index++;
			}
			res.add(str.toString());	
		}
		return res;
	}

	/**
	 * 
	 * @param res 结果集
	 * @param arrayList 当前组合
	 * @param len 输入字符串的长度
	 * @param digits 输入的字符串
	 * @param start 字符串开始的索引
	 */
	private static void core(List<List<Character>> res, List arrayList, int len,String digits,int start) {
		if(arrayList.size()==len) {
			res.add(new ArrayList<>(arrayList));
			return ;
		}
		if(start==len)return;
		for(int i=start;i<len;i++) {
			char c=digits.charAt(i);
			List<Character> singleMap=map.get(c);
			for(int j=0;j<singleMap.size();j++) {
				arrayList.add(singleMap.get(j));
				core(res, arrayList, len,digits,i+1);
				arrayList.remove(arrayList.size()-1);
			}
		}	
		
	}

}
