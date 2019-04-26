package leetcode;

import common.ListNode;

public class 删除链表的倒数第N个节点 {

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode head2=new ListNode(2);
		head.next=head2;
		ListNode res=removeNthFromEnd(head,2);
		if(res==null)
			System.out.println("null");
		else
			System.out.println(res.val);
	}
/**
 * 快慢指针法
 * 原理：
 * 快指针比慢指针多走了n步
 * 1.让fast先走n步
 * 2.让slow从head走，fast继续走下去
 * 3.当fast.next==null,删去 slow后一个节点
 * 注意：删除尾节点(n==1)和头节点(第2步之后slow==head)的情况
 * @param head
 * @param n
 * @return
 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null)return null;
		ListNode fast=head,slow=head;
		int fastIndex=0;
		while(fastIndex<n) {
			fastIndex++;
			fast=fast.next;
		}
		while(fast!=null&&fast.next!=null) {
			fast=fast.next;
			slow=slow.next;
		}

		if(slow.next==null) {
			return null;
		}
		else if(n==1) {
			slow.next=null;//删尾结点
		}else if(fast==null&&slow==head) {
			head=head.next;//删去头节点
		}else {
			slow.next=slow.next.next;//正常情况
		}
		return head;
	}

}
