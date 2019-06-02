package 剑指offer2;

import java.util.ArrayList;
import java.util.LinkedList;

import common.TreeNode;

public class 从上往下打印二叉树 {

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
		PrintFromTopToBottom(node);
	}

	/**
	 * 使用一个先进先出的队列把未打印左右节点的节点保存起来，
	 * 下次直接从头取出
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			System.out.print(node.val + ",");
			res.add(node.val);

		}
		return res;
	}

}
