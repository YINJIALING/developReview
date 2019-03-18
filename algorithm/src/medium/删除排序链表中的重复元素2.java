package medium;

import java.util.Arrays;

import common.CreatorListNodeByList;
import common.ListNode;

public class 删除排序链表中的重复元素2 {

	public static void main(String[] args) {
		ListNode head=new CreatorListNodeByList().creator(Arrays.asList(1,2,3,3,3,4,4,5));
		ListNode.print(head);
		ListNode.print(deleteDuplicates(head));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode left=head,right=head.next;
	
		while(right!=null) {
			while(right!=null&&right.next.val==right.val) {
				//delete it
				left.next=right.next;
				right=right.next;
			}
			while(right!=null&&left.next.val==right.val) {
				//move it
				right=right.next;
				left=left.next;
			}	
				
		}
		return head;
	}

}
