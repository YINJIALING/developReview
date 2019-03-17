package foreigncompany;

public class Node {
	private final int val;//不变模式
	private Node next;
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getVal() {
		return val;
	}
	public Node(int val) {
		super();
		this.val = val;
	}
	
	public static void printLinkedList(Node head) {
		while(head!=null) {
			System.out.print(head.getVal()+"->");
			head=head.getNext();
		}
			
		System.out.println();
	}

}
