package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 无重复字符的最长子串 {

	public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstring("aab"));
//		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	/**
	 *  遍历每个字符
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {	
		if(s==null||s.length()==0)return 0;
		Set<Character> set=new HashSet<>();
		int count=0;
		char[] c=s.toCharArray();
		int max=Integer.MIN_VALUE;
		for(int i=0;i<c.length;i++) {
			if(!set.contains(s.charAt(i))) {
				while(i<c.length-1&&c[i]==c[i+1]) {
					i++;
				}
				set.add(s.charAt(i));//第0个p没移除
				count++;
				max=max>count?max:count;
			}				
			else {
				count=0;
				set.removeAll(set);
			}
		}
		return max;
	}

}
