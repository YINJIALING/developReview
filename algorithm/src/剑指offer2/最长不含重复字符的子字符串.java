package 剑指offer2;

import java.util.Arrays;

public class 最长不含重复字符的子字符串 {

	public static void main(String[] args) {
		System.out.println(longestSubStringWithoutDuplication("arabcacfr"));
	}

	/**
	 * dp
	 * 
	 * @param string
	 * @return
	 */
	private static int longestSubStringWithoutDuplication(String str) {
		int curLength=0,maxlength=0;
		//存储每个字符上次出现的位置，-1表示从未出现
		int[] position=new int[26];
		Arrays.fill(position, -1);
		for(int i=0;i<str.length();i++) {
			//先找到该字符上次出现的位置
			int prevIndex=position[str.charAt(i)-'a'];
			//该字符未出现或出现的长度(d=i-prevIndex)大于f(i-1),此时f(i)=f(i-1)+1
			if(prevIndex<0||i-prevIndex>curLength) {
				curLength++;
			}else {
				//该字符出现的长度(d=i-prevIndex)小于f(i-1)，需要更新curLength
//				maxlength=curLength>maxlength?curLength:maxlength;
				curLength=i-prevIndex;
			}
			//更新该字符出现的位置
			position[str.charAt(i)-'a']=i;
			//每次记录最大长度
			maxlength=curLength>maxlength?curLength:maxlength;
		}
		return maxlength;
	}

}
