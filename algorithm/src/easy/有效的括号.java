package easy;

import java.util.Scanner;
import java.util.Stack;

/***
 * 栈
 */
public class 有效的括号 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 0;
		int num = in.nextInt();
		String[] nums = new String[num];
		while (num != 0) {
			if (num == 0)
				break;
			nums[i] = in.next();
			i++;
			num--;
		}

		for (int j = 0; j < nums.length; j++) {
			if(isValid(nums[j]))
				System.out.println("TRUE");
			else
				System.out.println("FALSE");
		}
	}

	private static boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		if (s.length() == 1)
			return false;
		char c[] = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		stack.push(c[0]);
		for (int i = 1; i < c.length; i++) {
			if (c[i] == '}' || c[i] == ')' || c[i] == ']') {
				if (isEqual(stack.peek(), c[i])) {
					stack.pop();
				}
			} else {
				stack.push(c[i]);
			}
		}
		if (stack.isEmpty() || stack.size() == 0)
			return true;
		return false;
	}

	private static boolean isEqual(char a, char b) {
		if ((a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']'))
			return true;
		else
			return false;
	}

}
