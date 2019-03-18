package easy;

import java.util.Arrays;

import common.CreatorListNodeByList;
import common.ListNode;

public class 删除排序链表中的重复元素 {

	public static void main(String[] args) {
		ListNode head=new CreatorListNodeByList().creator(Arrays.asList(1,1,2,3,3));
		ListNode.print(head);
		ListNode.print(deleteDuplicates(head));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode prev=head;
		if(prev==null||prev.next==null)return head;
		while(prev!=null&&prev.next!=null) {
			if(prev.next.val==prev.val) {
				//delete it
				prev.next=prev.next.next;
			}else 
			{
				prev=prev.next;
			}
			
		}
		return head;
	}

}
