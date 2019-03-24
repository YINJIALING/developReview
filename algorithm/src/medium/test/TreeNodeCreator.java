package medium.test;

import common.TreeNode;

public class TreeNodeCreator {

	public TreeNode creator() {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(1);
		root.right=new TreeNode(4);
		root.left.right=new TreeNode(2);
		return root;
		
	}
}
