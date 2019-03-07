package medium;

import java.util.Stack;

public class 逆波兰表达式求值 {

	public static void main(String[] args) {
//		System.out.println(evalRPN(new String[] {"2", "1", "+", "3", "*"}));		
		System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}

	/**
	 * 遇到数字存入栈，遇到符号取栈顶两个元素根据符号做运算
	 * @param tokens
	 * @return
	 */
	public static int evalRPN(String[] tokens) {
		int res=0;
		if(tokens==null||tokens.length==0)
			return res;
		if(tokens.length==1) {
			res=Integer.parseInt(tokens[0]);
			return res;
		}
			
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<tokens.length;i++) {
			if(isNumber(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
			}else {
				int a=stack.pop();
				int b=stack.pop();
				switch (tokens[i]) {
				case "/":res=b/a;break;
				case "*":res=b*a;break;
				case "+":res=b+a;break;
				case "-":res=b-a;break;
				}
				stack.push(res);
			}
		}
		return res;
	}

	/*(*
	 * 判断输入的字符串是否是一个数
	 */
	private static boolean isNumber(String string) {
		char[] c=string.toCharArray();
		int length=c.length-1;
		if(c[length]>='0'&&c[length]<='9')return true;
		return false;
	}

}
