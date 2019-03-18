package common;

public class ListNode {
 
	public int val;
	public ListNode next;
	public ListNode(int val) {
		super();
		this.val = val;
	}
	
	public static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println();
	}
	
}
