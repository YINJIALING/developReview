package 剑指offer2;

import java.util.ArrayList;
import java.util.Stack;

import common.ListNode;

public class 从尾到头打印链表 {

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode head1=new ListNode(2);
		ListNode head2=new ListNode(3);
		ListNode head3=new ListNode(4);
		ListNode head4=new ListNode(5);
		head.next=head1;
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		ArrayList<Integer> res=printListFromTailToHead2(head);
		for(Integer index:res) {
			System.out.print(index+",");
		}
	}

	/**
	 * 使用栈先进后出
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack=new Stack<>();
		while(listNode!=null) {
			stack.add(listNode.val);
			listNode=listNode.next;
		}
		ArrayList<Integer> array=new ArrayList<>();
		while(!stack.isEmpty()) {
			array.add(stack.pop());
		}
		return array;
	}
	
	/**
	 * 递归
	 * 每访问一个节点，先递归输出其后面的节点，再输出当前的节点
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> list=new ArrayList<>();
		printListFromTailToHead2Core(listNode,list);
		return list;
	}

	private static void printListFromTailToHead2Core(ListNode listNode, ArrayList<Integer> list) {
		if(listNode==null)return;
		printListFromTailToHead2Core(listNode.next,list);
		list.add(listNode.val);
		
	}
	

}
