package deadlineNewYear;

public class 对称的二叉树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
        		return true;
        return isSymmetrical(pRoot,pRoot);
    }

	private boolean isSymmetrical(TreeNode left,TreeNode right) {
		if(left==null&&right==null)
			return true;
		if(left==null||right==null)
			return false;
		return (left.val==right.val)&&isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
		
	}
}
