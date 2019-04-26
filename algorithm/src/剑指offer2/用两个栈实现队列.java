package 剑指offer2;

import java.util.Stack;

public class 用两个栈实现队列 {

	public static void main(String[] args) {
		用两个栈实现队列 demo=new 用两个栈实现队列();
		demo.push(1);
		demo.push(2);
		demo.push(3);
		System.out.println(demo.pop());
		demo.push(4);
		System.out.println(demo.pop());
		System.out.println(demo.pop());
		
	}
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    
    public void push(int node) {
    		stack1.push(node);
    }
    
    /*
     * 1.当stack2为空的时候，从stack1中弹出元素，推入stack2
     * 2.当stack2不为空的时候，直接从栈顶弹出元素
     */
    public int pop() {
    		if(stack2.isEmpty()) {
    			if(stack1.isEmpty()) return 0;
    			else {
    				while(!stack1.isEmpty()) {
    					stack2.push(stack1.pop());
    				}
    			}
    		}
    		return stack2.pop();
    		
    }

}
