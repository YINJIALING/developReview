package medium;

import common.ListNode;

public class 两数相加 {

	public static void main(String[] args) {
		ListNode l1=parseArrToList(new int[] {2 , 4 ,3});
		ListNode l2=parseArrToList(new int[] {5 ,6 , 4});
		print(l1);
		print(l2);
//		print(addTwoNumbers(l1,l2));
	}
	
	/**
	 * 遍历打印链表的每个值
	 * @param ListNode
	 */
	private static void print(ListNode listNode) {
		while(listNode.next!=null) {
			System.out.print(listNode.val+"->");
			listNode=listNode.next;
		}
		System.out.println();
	}

	/*
	 * 把一个数组解析成链表
	 */
	private static ListNode parseArrToList(int[] is) {
		ListNode l=new ListNode(is[0]);
		for(int i=1;i<is.length;i++) {
			ListNode tmp=new ListNode(is[i]);
			l.next=tmp.next;
		}
		
		return l;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {	
		StringBuffer str1=new StringBuffer();
		StringBuffer str2=new StringBuffer();
		while(l1.next!=null) {
			str1.append(l1.val);
			l1=l1.next;
		}
		while(l2.next!=null) {
			str2.append(l2.val);
			l2=l2.next;
		}
		
		long res=Long.parseLong(str1.toString())+Long.parseLong(str2.toString());
		char c[]=(res+"").toString().toCharArray();//8,0,7
		int i=c.length-1;
		ListNode resNode=new ListNode(Integer.parseInt(c[i]+""));
		while(i!=0) {
			resNode.next=new ListNode(Integer.parseInt(c[i]+""));i--;
			resNode=resNode.next;
		}
		
		return l2;
        
    }

}
