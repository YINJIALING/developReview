package deadlineNewYear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 从尾到头打印链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	List<Integer> list=new ArrayList<Integer>();
        if(listNode==null)
        	return (ArrayList<Integer>) list;
        list.add(listNode.val);
        while(listNode.next!=null) {
        	list.add(listNode.next.val);
        	listNode=listNode.next;
        }
         Collections.reverse(list);
        return (ArrayList<Integer>) list;
    }

}
class ListNode{
	int val;
	ListNode next;
	public ListNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListNode(int val) {
		super();
		this.val = val;
	}
	
}
