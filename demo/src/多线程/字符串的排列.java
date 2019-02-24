package 多线程;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 字符串的排列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private ArrayList<String> Permutation(String str) {
		Set<Character> res = filterToSet(str);
		List<String> list = new ArrayList<>();
		for(int i=0;i<res.size();i++) {
			
		}
		return (ArrayList<String>) list;
	}
	
	//去重
	private Set<Character> filterToSet(String str){
		Set<Character> res = new HashSet<>();
		char[] c = str.toCharArray();
		for(int i=0;i<c.length;i++) {
			res.add(c[i]);
		}
		return res;
	}

}
