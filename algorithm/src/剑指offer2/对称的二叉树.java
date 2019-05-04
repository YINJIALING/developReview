package 剑指offer2;

import common.TreeNode;

public class 对称的二叉树 {

	public static void main(String[] args) {
		

	}
	boolean isSymmetrical(TreeNode pRoot)
    {
       if(pRoot==null)return true;
       return isSymmetricalCore(pRoot.left,pRoot.right);
    }
	/**
	 * 如果是对称的，满足以下几项中的任意一项
	 * 1.left和right都是null( left,right有一个为null,一个不为null,返回false)
	 * 2.left.val==right.val&&left，right的子树也是对称的
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean isSymmetricalCore(TreeNode left,TreeNode right) {
		if(left==null&&right==null)return true;
		if(left==null||right==null)return false;
		return (left.val==right.val)&&isSymmetricalCore(left.left,right.right)
				&&isSymmetricalCore(right.left,left.right);
	}

}
