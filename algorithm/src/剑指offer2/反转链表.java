package 剑指offer2;

import common.ListNode;

public class 反转链表 {

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode res = ReverseList2(node);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}

	// 递归
	/**
	 * 0-1-2-3-4 设0后面已经全部反转成功，只要将0也反转即可 1.将0的next(node 1)的next设为0 2. 将0的next设为null
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList(ListNode head) {
		if (head.next == null)
			return head;
		ListNode newHead = ReverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;

	}

	// 循环
	/**
	 * 1->2->3->4->5
	 * 每次将pNode的next更为pPrev，然后向右推进一步
	 * pNode:node2,pPrev=1;
	 * 1<-2->3->4->5
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList2(ListNode head) {
		ListNode pNode = head, pPrev = null, newhead = null;
		while (pNode != null) {
			ListNode pNext=pNode.next;
			if(pNext==null)
				newhead=pNode;
			pNode.next=pPrev;
			pPrev=pNode;
			pNode=pNext;
		}
		return newhead;
	}

}
