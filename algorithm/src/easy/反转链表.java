package easy;

import common.ListNode;
/**
 * 链表链接：
 * https://www.jianshu.com/p/a64d1ef95980
 * @author YJL
 *
 */
public class 反转链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//递归
	public ListNode reverseList(ListNode head) {
		if(head.next==null)
			return head;
		ListNode newHead=reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
	
	//非递归
		public ListNode reverseList2(ListNode head) {
			ListNode prev=null;
			if(head==null)return prev;
			
			while(head!=null) {
				ListNode tmp=head.next;
				head.next=prev;
				prev = head;
				head = tmp;
			}
			return prev;
		}

}
