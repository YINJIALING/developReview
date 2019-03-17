package foreigncompany;

import java.util.Arrays;
/**
 * 必考
 * @author yinjialing
 *
 */
public class LinkedListReserve {

	public static void main(String[] args) {
		Node.printLinkedList(reserve2(new LinkedNodeCreator().createLinkedList(Arrays.asList(1,2,3,4,5))));
	}
	
	/**
	 * 递归stack overflow
	 * reverses a linked list
	 * @param head
	 * @return head of the reversed linked list
	 */
	private static Node reserve(Node head) {
		if(head==null||head.getNext()==null)
			return head;
		Node newHead=reserve(head.getNext());// 假设除了1以外其他链表能正确的反转，此时只要反转1
		head.getNext().setNext(head);//原来1的getNext=2，执行了这句话之后2的next为1
		head.setNext(null);
		return newHead;
	}
	
	/**
	 * loop
	 * @param head
	 * @return
	 */
	private static Node reserve2(Node head) {
		Node newhead =null,currentHead=head;
		while(currentHead!=null) {//loop invariant
			//newhead points to the linked list already reserved
			//currentHead points to the linked list not yet reserved
			Node next=currentHead.getNext();
			currentHead.setNext(newhead);
			newhead=currentHead;
			currentHead=next;
		}
		return newhead;
	}

}
