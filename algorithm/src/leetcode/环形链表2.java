package leetcode;

import common.ListNode;
/**
 * 1.先判断链表是否有环，快慢指针法，如果有环返回两指针相遇的节点B
 * 2.假设从开始节点到链表入口A长度为a，从A到B长度为b, 那么快指针走了2(a+b),慢指针走了a+b.
 * 快指针比慢指针多走了a+b，如果指针cur从B开始走a+b会再次到达B
 * 如果cur从B出发走a会到达A,p从head开始走a到A
 * 因此当cur和p相遇时，就到了A
 * @author yinjialing
 *
 */
public class 环形链表2 {

	public static void main(String[] args) {
		ListNode root=new ListNode(3);
		ListNode root2=new ListNode(2);
		root.next=root2;
		ListNode root3=new ListNode(0);
		root2.next=root3;
//		ListNode root4=new ListNode(-1);
//		root3.next=root4;
//		root4.next=root2;
		System.out.println(detectCycle(root));
	}
	public static ListNode detectCycle(ListNode head) {
		if(head==null)return null;
		ListNode cur=hasCircle(head);
		if(cur==null)return null;
		ListNode p=head;
		while(p!=cur) {
			cur=cur.next;
			p=p.next;
		}
		return p;
	}

	//判断是否有环，有则返回当前的节点
	private static ListNode hasCircle(ListNode head) {
		ListNode i=head,j=head;
		while(j.next!=null&&i.next!=null&&i.next.next!=null) {
			i=i.next.next;
			j=j.next;
			if(i==j)return i;
		}
		return null;
	}

}
