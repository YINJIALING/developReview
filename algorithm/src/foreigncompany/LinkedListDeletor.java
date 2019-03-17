package foreigncompany;

import java.util.Arrays;

public class LinkedListDeletor {

	public static void main(String[] args) {
		Node.printLinkedList(delete(new LinkedNodeCreator().createLinkedList(Arrays.asList(1,2,3,2,5)),2));
	}
	
	private static Node delete(Node head,int n) {
		Node prev=head;
		if(head==null)return prev;
		while(head!=null&&head.getVal()==n) {
			//delete it
			head=head.getNext();
		}
		while(prev.getNext()!=null) {
			if(prev.getNext().getVal()==n) {
				//delete it and current node will be gc
				prev.setNext(prev.getNext().getNext());
			}else {
				//move
				prev=prev.getNext();
			}
		}
		
		return head;
	}

}
