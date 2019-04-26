package leetcode;

import common.ListNode;

public class 排序链表 {

	public static void main(String[] args) {
//		ListNode head=new ListNode(4);
//		ListNode head2=new ListNode(2);
//		ListNode head3=new ListNode(1);
//		ListNode head4=new ListNode(3);
//		head.next=head2;
//		head2.next=head3;
//		head3.next=head4;
		ListNode head=new ListNode(-1);
		ListNode head2=new ListNode(-2);
//		ListNode head3=new ListNode(3);
//		ListNode head4=new ListNode(4);
//		ListNode head5=new ListNode(0);
		head.next=head2;
//		head2.next=head3;
//		head3.next=head4;
//		head4.next=head5;
		ListNode res=sortList(head);
		if(res==null)
			System.out.println("null");
		else {
			while(head!=null) {
				System.out.print(head.val+",");
				head=head.next;
			}
			System.out.println();
		}
	}

	/**
	 * 交换值，冒泡
	 * @param head
	 * @return
	 */
	public static ListNode sortList(ListNode head) {
		if(head==null)return head;
		ListNode p=head;
		ListNode q=head.next;
		while(p!=null&&p.next!=null) {
			if(q==null&&p.next.next!=null) {
				p=p.next;
				q=p.next;
			}else if(q==null&&p.next.next==null)
				break;
			if(q.val<p.val) {
				int tmp=p.val;
				p.val=q.val;
				q.val=tmp;
			}else {
				q=q.next;
			}
		}
		return head;
	}
	
	/**
	 * 快速排序，有人说头条面试会问
	 * 交换节点版，非交换值
	 * @param head
	 * @return
	 */
	public static ListNode sortList2(ListNode head) {
		ListNode newHead=null;
		newHead.next=head;
		return quickSort(newHead,null);
	}
	
	/**
	 *  归并排序
	 * 交换节点版，非交换值
	 * @param head
	 * @return
	 */

	private static ListNode quickSort(ListNode head, ListNode end) {
		
		return null;
	}

}
