package foreigncompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedNodeCreator {

	public static void main(String[] args) {
		LinkedNodeCreator creator=new LinkedNodeCreator();
		Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
		Node.printLinkedList(creator.createLinkedList(Arrays.asList(1,2,3)));
	}
	
	/**
	 * This is a comment.
	 * creates a linked list by list
	 * 
	 * @param data
	 * @return head of the linked list.The return linked list ends with last node with getNext()==null.
	 */
	public Node createLinkedList(List<Integer> data) {
		if(data.isEmpty())
			return null;
		
		Node firstNode=new Node(data.get(0));
		Node headOfSublist=createLinkedList(data.subList(1, data.size()));
		firstNode.setNext(headOfSublist);
		return firstNode;
	}

}
