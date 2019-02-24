package deadlineNewYear;

public class 树的子结构 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//递归
	
public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null)
        	return false;
        //如果root2是子树，要么是root1的子树，要么是root1.left 的子树，要么是 root2.right的子树
        return isSubTree(root1,root2)||isSubTree(root1.left,root2)||isSubTree(root1.right,root2);
        
    }
private boolean isSubTree(TreeNode root1,TreeNode root2) {
	if(root2==null)
		return true;
	if(root1==null)
		return false;
	if(root2.val==root1.val)
		return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
	else
		return false;
}

}
