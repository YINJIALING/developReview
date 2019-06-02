package 剑指offer2;

import java.util.Arrays;
/*
 * 插入：如果出现了一次就把对应数组上的值更新为对应位置。如果出现不止一次，就将该值为-2
 * 返回第一次只出现一次的字符：遍历数组，发现只出现一次的数组比较他们的位置取最小
 */
public class 字符流中第一个只出现一次的字符 {
	int[] occurrence=new int[256];
	int index=0;//记录该字符在字符串的位置
	
	public 字符流中第一个只出现一次的字符() {
		
		Arrays.fill(occurrence, -1);
	}

	public static void main(String[] args) {
		字符流中第一个只出现一次的字符 t=new 字符流中第一个只出现一次的字符();
		t.insert('g');t.insert('o');t.insert('o');
		System.out.println(t.firstAppearingOnce());
		t.insert('g');t.insert('l');t.insert('e');
		System.out.println(t.firstAppearingOnce());
	}

	private void insert(char c) {
		if(occurrence[c]==-1)
			occurrence[c]=index;//更新为该字符在字符串的位置
		else
			occurrence[c]=-2;
		
		index++;
	}

	private char firstAppearingOnce() {
		int minIndex=Integer.MAX_VALUE;
		char ch = 0;
		for(int i=0;i<occurrence.length;i++) {
			if(occurrence[i]>=0&&occurrence[i]<minIndex) {
				minIndex=occurrence[i];
				ch=(char) i;
			}
				
		}
		return ch;
	}
	

}
