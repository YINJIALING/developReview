package leetcode;

import common.ListNode;

public class 相交链表 {

	public static void main(String[] args) {
		ListNode headA1=new ListNode(4);
		ListNode headA2=new ListNode(1);
		ListNode headB1=new ListNode(5);
		ListNode headB2=new ListNode(0);
		ListNode headB3=new ListNode(1);
		ListNode common1=new ListNode(8);
		ListNode common2=new ListNode(4);
		ListNode common3=new ListNode(5);
		headA1.next=headA2;
		headA2.next=common1;
		common1.next=common2;
		common2.next=common3;
		headB1.next=headB2;
		headB2.next=headB3;
		headB3.next=common1;
		ListNode res=getIntersectionNode(headA1,headB1);
		if(res==null)
			System.out.println("null");
		else
			System.out.println(res.val);
	}

	/**
	 * 1.先算出两个链表的长度a,b
	 * 2.让较长的链表先走|a-b|，然后和另外一个链表一起走，当他们相交时，即为相交的起始节点
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null)return null;
		int a=getLength(headA),b=getLength(headB),diff;
//		System.out.println("a:"+a+",b:"+b);
		ListNode p=headA,q=headB;
		if(a>b) {
			diff=a-b;
			while(diff!=0) {
				p=p.next;
				diff--;
			}
		}else if(a<b) {
			diff=b-a;
			while(diff!=0) {
				q=q.next;
				diff--;
			}
		}else if(a==b&&p==q){
			return p;//如果长度一样，且头结点相同，那么从头结点开始相交
		}
		while(p!=q&&p!=null&&q!=null) {
			p=p.next;
			q=q.next;
		}
		if(p==q)
			return p;
		else 
			return null;
	}

	//计算链表的长度
	private static int getLength(ListNode head) {
		ListNode cur=head;
		int count=0;
		while(cur!=null) {
			count++;
			cur=cur.next;
		}
		return count;
	}

}
