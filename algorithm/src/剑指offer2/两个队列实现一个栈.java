package 剑指offer2;

import java.util.LinkedList;
import java.util.Queue;
/*
 * 1.当push时存入非空的队列，如果两个队列都为空，放入队列1
 * 2.当pop的时候，先将非空的队列1的元素拷贝至另外一个空的队列2，直到1的元素个数只有1，把剩下的这个元素弹出
 */
public class 两个队列实现一个栈 {
	Queue<Integer> queue1=new LinkedList<>();
	Queue<Integer> queue2=new LinkedList<>();

	public static void main(String[] args) {
		两个队列实现一个栈 t=new 两个队列实现一个栈();
		t.push(1);t.push(2);t.push(3);System.out.println(t.pop());
		t.push(4);System.out.println(t.pop());
	}
	private void push(int val) {
		if(queue1.isEmpty()&&queue2.isEmpty())
			queue1.add(val);
		else if(queue1.isEmpty())
			queue2.add(val);
		else
			queue1.add(val);	
	}
	private int pop() {
		if(queue1.isEmpty()&&queue2.isEmpty())return -1;
		else if(queue1.isEmpty()) {
			while(queue2.size()!=1) {
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}else {
			while(queue1.size()!=1) {
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
	}

}
