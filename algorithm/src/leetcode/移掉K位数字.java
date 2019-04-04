package leetcode;

import java.util.Stack;

public class 移掉K位数字 {

	public static void main(String[] args) {
		System.out.println(removeKdigits("1432219",3));
//		System.out.println(removeKdigits("10200",1));
	}

	public static String removeKdigits(String num, int k) {
		int digits=num.length()-k;//输出字段的长度
		char[] stk=new char[num.length()];//模拟栈
		int top=0;
		for(int i=0;i<num.length();i++) {
			char c=num.charAt(i);
			while(top>0&&stk[top-1]>c&&k>0) {//如果stk[top-1](栈顶元素)小于c，则更新栈顶元素
				top--;k--;
			}
			stk[top]=c;
			top++;
		}
		
		int idx=0;
		while(idx<digits&&stk[idx]=='0') {//消去0
			idx++;
		}
		return idx==digits?"0":new String(stk,idx,digits-idx);
	}

}
