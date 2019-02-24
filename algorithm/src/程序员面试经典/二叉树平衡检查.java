package 程序员面试经典;

import common.TreeNode;

public class 二叉树平衡检查 {

	public static void main(String[] args) {

	}
	/**
	 * if(|left.high-right.high|<1)
	 *		return true;
	 * @param root
	 * @return
	 */
	public boolean isBalance(TreeNode root) {
		if(root==null)
			return true;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        return (left-right>1||left-right<-1)?false:true;
    }

	//求二叉树的最大高度
	private int getDepth(TreeNode root) {
		if(root==null)
			return 1;
		int left=getDepth(root.left);
		int right=getDepth(root.right);
		return left>right?left+1:right+1;
	}
}
