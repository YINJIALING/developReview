package leetcode;

import common.ListNode;

public class 两个链表相加 {

	//1.2个链表先反转
	//2.将反转之后的链表相加，并考虑进位
	//3.生成新的链表再反转
	public static void main(String[] args) {
		ListNode node=new ListNode(2);
		ListNode node1=new ListNode(4);
		ListNode node2=new ListNode(3);
		node.next=node1;node1.next=node2;
		ListNode node11=new ListNode(5);
		ListNode node12=new ListNode(6);
//		ListNode node13=new ListNode(4);
		node11.next=node12;
//		node12.next=node13;
		ListNode res=generateResult(node,node11);
		while(res!=null) {
			System.out.print(res.val+",");res=res.next;
		}
	}

	private static ListNode generateResult(ListNode l1, ListNode l2) {
		ListNode  listNode= new ListNode(0);
        ListNode p = listNode;
        int sum = 0;
 
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            sum = sum / 10;
            p = p.next;
        }
        return listNode.next;
	}

	

}
