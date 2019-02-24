package 程序员面试经典;

import java.util.HashSet;
import java.util.LinkedList;

import common.UndirectedGraphNode;

/**
 * 有向图的遍历，分别深度优先遍历 Stack和广度优先遍历Queue
 * @author yinjialing
 *
 */
public class 有向路径检查 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		 if(a==null||b==null) return false;
			boolean res1 = findNode(a, b);//检查a到b是否有一条有向路径
			if(res1==true) return true;
			boolean res2 = findNode(b, a);//检查b到a是否有一条有向路径
			return res2;
	    }

	private boolean findNode(UndirectedGraphNode a, UndirectedGraphNode b) {
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		queue.add(a);
		set.add(a);
		while(!queue.isEmpty()){
			UndirectedGraphNode tmp = queue.removeFirst();
			if(tmp==b) return true;
			for(UndirectedGraphNode w : tmp.neighbors){
				if(set.contains(w)) continue;
				queue.add(w);
				set.add(w);
			}
		}
		return false;
	}

}
