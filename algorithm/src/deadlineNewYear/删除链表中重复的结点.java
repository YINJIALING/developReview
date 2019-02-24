package deadlineNewYear;

public class 删除链表中重复的结点 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 4, 4, 5 };
		ListNode head = new ListNode();
		ListNode cur = head;
		for (int index : array) {
			ListNode node = new ListNode(index);
			cur.next = node;
			cur = node;
		}
		printNode(head.next);
		ListNode res = deleteDuplication(head);
		printNode(res.next);
	}

//	public static ListNode deleteDuplication(ListNode pHead) {
//			if (pHead==null || pHead.next==null){return pHead;}
//			ListNode Head = new ListNode(0);
//			Head.next = pHead;
//			ListNode pre  = Head;
//			ListNode last = Head.next;
//			while (last!=null){
//			    if(last.next!=null && last.val == last.next.val){
//			        // 找到最后的一个相同节点
//			        while (last.next!=null && last.val == last.next.val){
//			            last = last.next;
//			        }
//			        pre.next = last.next;
//			        last = last.next;
//			    }else{
//			        pre = pre.next;
//			        last = last.next;
//			    }
//			}
//			return Head.next;
//	}
	
	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead==null || pHead.next==null){return pHead;}//没有结点和只有一个结点的情况
		ListNode res=new ListNode(0);
		res.next=pHead;
		ListNode pre=res;//因为有可能头指针也要删除的情况
		ListNode cur=res.next;
		while(cur!=null) {
			if(cur.next!=null&&cur.next.val==cur.val) {
				while(cur.next!=null&&cur.val==cur.next.val) {
					cur=cur.next;
				}
				pre.next=cur.next;
				cur=cur.next;
			}else {
				pre=pre.next;
				cur=cur.next;
			}
		}
		return res.next;
		
}
	
	

	private static void printNode(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val);
			cur = cur.next;
		}
		System.out.println();
	}

}
