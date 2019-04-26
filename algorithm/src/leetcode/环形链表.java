package leetcode;

import common.ListNode;

public class 环形链表 {

	public static void main(String[] args) {
		ListNode head1=new ListNode(3);
		ListNode head2=new ListNode(2);
		ListNode head3=new ListNode(0);
		ListNode head4=new ListNode(-1);
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head2;
		System.out.println(hasCycle(head1));
	}

	/**
	 * 快慢指针
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {
		if(head==null)return false;
		ListNode fast=head,slow=head;
		boolean flag=true;
		while((flag||fast!=slow)&&fast!=null&&fast.next!=null&&slow!=null) {
			flag=false;
			fast=fast.next.next;
			slow=slow.next;
		}
		if(fast==slow&&!flag)return true;
		else
			return false;
	}

}
