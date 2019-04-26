package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class 二叉树的右视图 {

	public static void main(String[] args) {
		TreeNode node=new TreeNode(3);
		TreeNode node1=new TreeNode(5);
		TreeNode node2=new TreeNode(1);
		TreeNode node3=new TreeNode(6);
		TreeNode node4=new TreeNode(2);
		TreeNode node5=new TreeNode(0);
		TreeNode node6=new TreeNode(8);
		TreeNode node7=new TreeNode(7);
		TreeNode node8=new TreeNode(4);
		node.left=node1;node.right=node2;
		node1.left=node3;node1.right=node4;node2.left=node5;node2.right=node6;
		node4.left=node7;node4.right=node8;
		List<Integer> res=rightSideView(node);
		for(Integer index:res)
			System.out.print(index+",");
		
	}

	/**
	 * 返回每层的最后一个节点
	 * 根据二叉树的宽度遍历
	 * @param root
	 * @return
	 */
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> view=new ArrayList<>();
		Queue<Pair> queue=new LinkedList<>();
		if(root==null)return view;
		queue.add(new Pair(root,0));
		while(!queue.isEmpty()) {
			Pair pair=queue.poll();
			TreeNode node=pair.node;
			int depth=pair.layer;//待遍历的层数
			if(view.size()==depth)
				view.add(node.val);//如果当前层数等于view的大小，将当前value加入view
			else
				view.set(depth, node.val);//否则，根据层数更新view
			if(node.left!=null)
				queue.add(new Pair(node.left,depth+1));
			if(node.right!=null)
				queue.add(new Pair(node.right,depth+1));
		}
		return view;
	}

}
class Pair{
	TreeNode node;
	int layer;
	public Pair(TreeNode node, int layer) {
		super();
		this.node = node;
		this.layer = layer;
	}
	
}
