package leetcode;

import java.util.Stack;

public class 最长有效括号 {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())"));
	}

	public static int longestValidParentheses(String s) {
		Stack<Character> stack=new Stack<>();
		int count=0;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c==')'&&!stack.isEmpty()) {
				stack.pop();
				count++;
			}else if(c=='(')
				stack.push(c);
		}
		return 2*count;
	}

}
