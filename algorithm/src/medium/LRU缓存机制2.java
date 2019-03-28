package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用自定义双向链表实现一个linkedHashMap
 * @author yinjialing
 *
 */
class Node{
	int key;
	int value;
	Node pre;
	Node next;
	public Node(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
public class LRU缓存机制2 {
	 public int capacity;
	 public Map<Integer,Node> map;
	 public Node tail;//设一个虚拟的尾节点
	 public Node head;//设一个虚拟的头节点
	 public int size;//链表长度
	 
	  public LRU缓存机制2(int capacity){
		  this.capacity=capacity;
		  map=new HashMap<>();
		  head=new Node(0,0);
		  tail=new Node(0,0);
		  
		  head.pre=null;
		  head.next=tail;
		  tail.pre=head;
		  tail.next=null;
		  
	  }
	  
	  public int get(int key) {
			int value=-1;
			if(map.containsKey(key)) {
				value=map.get(key).value;
				removeNode(map.get(key));//将该节点从map中移除
				addToHead(map.get(key));//将该节点放到map中的第一位
			}
			
			return value;
		}
		//将node添加至head后，原head之前
		private void addToHead(Node node) {
		node.next=head.next;//把head.next和head断开，将head.next和node连接
		node.next.pre=node;//将node.next的pre节点指向node
		node.pre=head;//将node的pre节点指向head
		head.next=node;
	}

		private void removeNode(Node node) {
		node.pre.next=node.next;
		node.next.pre=node.pre;
	}

		public void put(int key, int value) {
			if(map.get(key)!=null) {
				removeNode(map.get(key));
				map.remove(key);
				size--;
			}
			Node node=new Node(key,value);
			map.put(key, node);
			if(size<capacity) {
				addToHead(node);
				size++;
			}else {
				Node remove=tail.pre;
				removeNode(remove);
				map.remove(remove.key);
				addToHead(node);
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
