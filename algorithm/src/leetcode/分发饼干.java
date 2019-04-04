package leetcode;

import java.util.Arrays;

public class 分发饼干 {

	public static void main(String[] args) {
		System.out.println(findContentChildren(new int[] {7,8,9,10},new int[] {5,6,7,8}));
	}

	//g;孩子所需要的饼干，s:一个饼干的重量
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count=0,i=0,j=0;
		while(i<s.length&&j<g.length) {
			if(g[j]<=s[i]) {
				i++;
				j++;
				count++;
			}else {
				++i;
			}
		}
		return count;
	}

}
