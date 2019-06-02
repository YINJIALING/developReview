package 剑指offer2;

import common.TreeNode;

public class 二叉树的深度 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(11);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		System.out.println(TreeDepth(node));

	}

	/**
	 * 如果root为空，返回0
	 * 如果root非空，计算左节点的长度和右节点的长度，返回两个值中的最大值并加1
	 * @param root
	 * @return
	 */
	public static int TreeDepth(TreeNode root) {
		if(root==null)return 0;
		
		int 	left=TreeDepth(root.left);
		int	right=TreeDepth(root.right);
		
		return Math.max(left, right)+1;
	}

}
