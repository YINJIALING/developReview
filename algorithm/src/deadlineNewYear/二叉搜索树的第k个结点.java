package deadlineNewYear;

import java.util.ArrayList;

public class 二叉搜索树的第k个结点 {
	ArrayList<TreeNode> array=new ArrayList<TreeNode>();	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 二叉搜索树的中序遍历，满足升序排序的条件 
	 * 1.中序遍历，返回遍历的队列
	 * 2.从保存的队列中找出第k小的值
	 * @param pRoot
	 * @param k
	 * @return
	 */
	TreeNode KthNode(TreeNode pRoot, int k)
    {
       if(pRoot==null||k==0)return null;
       inOrder(pRoot);//中序遍历
       TreeNode tr=pRoot;
       if(k<=array.size()) {
    	   	tr=array.get(k-1);
       }else
    	   return null;
       return tr;
    }
	private void inOrder(TreeNode pRoot) {
		if(pRoot==null)return;
		if(pRoot.left!=null)
			inOrder(pRoot.left);
		array.add(pRoot);
		if(pRoot.right!=null)
			inOrder(pRoot.right);
	}
}
