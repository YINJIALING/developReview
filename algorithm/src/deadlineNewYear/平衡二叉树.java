package deadlineNewYear;

public class 平衡二叉树 {

	/**
	 * 平衡二叉树左右子树的高度差不超过1
	 * 缺点是：每判断一棵树的就要遍历该树的结点，结果是每个结点不止被遍历过一次
	 * @param root
	 * @return
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root==null)
			return true;//一颗空树就是平衡二叉树
		int leftDepth=getDepth(root.left);
		int rightDepth=getDepth(root.right);
		int diff=leftDepth-rightDepth;
		if(diff>1||diff<-1)
			return false;
		return true;
	}

	private int getDepth(TreeNode root) {
		if(root==null)
			return 0;
		int left=getDepth(root.left);
		int right=getDepth(root.right);
		return left>right?left+1:right+1;
	}
	
	public boolean IsBalanced_Solution2(TreeNode root) {
		int depth=0;
		return IsBalanced_Solution2(root,0);
	}

	private boolean IsBalanced_Solution2(TreeNode root, int depth) {
		if(root==null) {
			depth=0;
			return true;
		}
		int left=0,right=0;
		if(IsBalanced_Solution2(root.left,left)&&IsBalanced_Solution2(root.right,right)) {
			int diff=left-right;
			if(diff>1||diff<-1)
				return false;
			else {
				depth=left>right?left+1:right+1;
				return true;
			}		
		}
		return false;
	}
}
