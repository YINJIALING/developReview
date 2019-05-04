package 剑指offer2;

public class 复杂链表的复制 {
	public static void main(String[] args) {
		RandomListNode node=new RandomListNode(1);
		RandomListNode node0=new RandomListNode(2);
		RandomListNode node1=new RandomListNode(3);
		RandomListNode node2=new RandomListNode(4);
		RandomListNode node3=new RandomListNode(5);
		node.next=node0;node0.next=node1;node1.next=node2;node2.next=node3;
		RandomListNode newhead=Clone(node);
		
		System.out.println("------");
		while(newhead!=null) {
			RandomListNode tmp=newhead.random;
			if(tmp!=null)
				System.out.print(newhead.label+"("+tmp.label+")"+"->");
			else
				System.out.print(newhead.label+"(null)"+"->");
			newhead=newhead.next;
		}
		
	}
	public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)return null;
		cloneNodes(pHead);
        connectSiblingNodes(pHead);
        RandomListNode newhead=reconnectNodes(pHead);
        return newhead;
       
    }

	/**
	 * 3. 将链表拆分成2个链表
	 * 奇数位上的是原始链表
	 * 偶数位上的是复制结果
	 * @param pHead
	 * @return
	 */
	private static RandomListNode reconnectNodes(RandomListNode pHead) {
		RandomListNode pNode=pHead,pClonedHead=null,pClonedNode=null;
		//给pClonedNode，pClonedNode设置初值
		if(pNode!=null) {
			pClonedNode=pNode.next;
			pClonedHead=pClonedNode;
			pNode.next=pClonedNode.next;
			pNode=pNode.next;
		}
		while(pNode!=null) {
			pClonedNode.next=pNode.next;
			pClonedNode=pClonedNode.next;
			pNode.next=pClonedNode.next;
			pNode=pNode.next;
		}
		return pClonedHead;
	}
	/**
	 * 2.如果原始节点的random指向其他节点，那么复制出来也要指向其他节点的复制节点
	 * @param pHead
	 */
	private static void connectSiblingNodes(RandomListNode pHead) {
		RandomListNode pNode=pHead;
		while(pNode!=null) {
			RandomListNode pCloned=pNode.next;
			if(pNode.random!=null) {
				pCloned.random=pNode.random.next;
			}
			pNode=pCloned.next;
		}
		
	}
	/**
	 * 1.先复制原始链表的任意节点，把新复制的节点连接到原节点后面
	 * @param pHead
	 */
	private static void cloneNodes(RandomListNode pHead) {
		RandomListNode pNode=pHead;
		while(pNode!=null) {
			RandomListNode pCloned=new RandomListNode(pNode.label);
			pCloned.next=pNode.next;
			pCloned.random=null;
			pNode.next=pCloned;
			pNode=pCloned.next;
		}
		
	}
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
