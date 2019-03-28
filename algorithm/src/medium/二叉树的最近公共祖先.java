package medium;

import common.TreeNode;

public class 二叉树的最近公共祖先 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		System.out.println(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root.val == p.val || root.val == q.val)
			return root;//找到p或q
		//递归左子树，找到左子树中的p或q
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		//递归右子树，找到右子树中的p或q
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//如果左子树找不到任何一个，返回右子树
		if (left == null)
			return right;
		//如果右子树找不到任何一个，返回左子树
		if (right == null)
			return left;
		//左右子树都能找到一个，说明当前root是祖先节点
		return root;
	}

}
