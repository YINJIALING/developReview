package deadlineSpringFestival;

import common.ListNode;

public class 合并两个有序链表 {

	public static void main(String[] args) {
		int[] arr1= {1,2,4};
		int[] arr2= {1,3,4};
		ListNode l1=setListNode(arr1);
		print(l1);
		ListNode l2=setListNode(arr2);
		print(l2);
		ListNode res=mergeTwoLists(l1,l2);
		print(res);
	}
	
private static void print(ListNode res) {
	while(res.next!=null) {
		System.out.print(res.val+" ");
		res=res.next;
	}
System.out.println();		
	}

private static ListNode setListNode(int[] arr1) {
	ListNode res = null;
	ListNode cur = res;
	for(int i=0;i<arr1.length;i++) {
		cur=new ListNode(arr1[i]);
		cur.next=cur;
	}	
		return cur;
	}

public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode res=null;
	ListNode cur=res;
        ListNode curL1=l1;
        ListNode curL2=l2;
        while(curL1.next!=null&&curL2.next!=null) {
        	if(curL1.val<curL2.val) {
        		cur=new ListNode(curL1.val);
        		res.next=cur;
            	curL1=curL1.next;
            }else{
            	cur=new ListNode(curL2.val);
            	res.next=cur;
            	curL1=curL2.next;
            }
        }
        
        	while(curL1.next!=null) {
        		cur=new ListNode(curL1.val);
        		res.next=cur;
            	curL1=curL1.next;
        	}
        
        	while(curL2.next!=null) {
        		cur=new ListNode(curL2.val);
        		res.next=cur;
            	curL2=curL2.next;
        	}
        return res.next;
    }

}
