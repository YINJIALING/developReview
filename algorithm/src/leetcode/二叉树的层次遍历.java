package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class 二叉树的层次遍历 {
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
		print(node);
		
	}

	private static void print(TreeNode node) {
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			TreeNode cur=queue.poll();
			System.out.println(cur.val);
			if(cur.left!=null)
				queue.add(cur.left);
			if(cur.right!=null)
				queue.add(cur.right);
		}
	}
}
