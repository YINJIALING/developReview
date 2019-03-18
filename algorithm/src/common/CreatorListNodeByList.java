package common;

import java.util.List;

public class CreatorListNodeByList {
	public ListNode creator(List<Integer> list) {
		if(list.isEmpty())return null;
		ListNode head=new ListNode(list.get(0));
		head.next=creator(list.subList(1, list.size()));
		return head;
	}

}
