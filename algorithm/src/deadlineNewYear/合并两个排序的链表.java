package deadlineNewYear;

public class 合并两个排序的链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 非递归
	public ListNode merge(ListNode list1, ListNode list2) {
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;

		ListNode current = new ListNode(-1);
		ListNode res = current;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				// 如果list1当前值比list2小,就把list1当前值加到res中
				current.next = list1;
				current = list1;// current指针后移
				list1 = list1.next;// list1指针后移
			} else {
				current.next = list2;
				current = list2;// current指针后移
				list2 = list2.next;// list2指针后移
			} // 跳出这个循环肯定是因为list1,list2有一个==null	
		}
		if (list1 != null)
			current.next = list1;
		if (list2 != null)
			current.next = list2;
		return res.next;

	}

	/**
	 * 递归
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode merge2(ListNode list1, ListNode list2) {
		ListNode head=null;
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;
		if (list1.val < list2.val) {
			head = list1;
			head.next = merge2(list1.next, list2);
		} else {
			head = list2;
			head.next = merge2(list1, list2.next);
		}
		return head;
	}

}
