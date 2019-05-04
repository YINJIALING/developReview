package 剑指offer2;

import common.TreeNode;

public class 二叉树的镜像 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 1.交换root的左节点和右节点
	 * 2.把左节点作为root,使左节点的子树交换
	 * 3.把右节点作为root,使右节点的子树交换
	 * @param root
	 */
public void Mirror(TreeNode root) {
         if(root==null) return;
         TreeNode tmp=root.left;
         root.left=root.right;
         root.right=tmp;
         Mirror(root.left);
         Mirror(root.right);
    }

}
