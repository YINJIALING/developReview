package 剑指offer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 字符串的排列 {

	public static void main(String[] args) {
		ArrayList<String> res=Permutation("bcd");
		for(String index:res)
			System.out.println(index);

	}

	public static ArrayList<String> Permutation(String str) {
		HashSet<String> list=new HashSet<>(); //去重
		if(str==null||str.length()==0)
			return new ArrayList<>();
		Permutation(new StringBuffer(str),0,list);
		ArrayList<String> res=new ArrayList<>(list);
		//将结果排序
		Collections.sort(res);
		return res;
	}

	/**
	 * 
	 * @param str
	 * @param pBegin 当前需交换的第一个坐标
	 * abc
	 * 
	 */
	private static void Permutation(StringBuffer str,int pBegin,HashSet<String> list) {
		if(pBegin>=str.length()) {
			System.out.println(str.toString());
			list.add(new String(str.toString()));
			return;
		}
		for(int i=pBegin;i<str.length();i++) {
			swap(str,i,pBegin);
			Permutation(str,pBegin+1,list);
			swap(str,i,pBegin);
		}
		
	}

	private static void swap(StringBuffer str, int pBegin, int i) {
		char tmp=str.charAt(pBegin);
		str.setCharAt(pBegin, str.charAt(i));//在一个字符串中根据坐标更改值
		str.setCharAt(i,tmp);
	}

}
