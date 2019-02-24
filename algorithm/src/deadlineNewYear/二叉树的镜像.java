package deadlineNewYear;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的镜像 {

	public void Mirror(TreeNode root) {
		if(root==null)
			return ;
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		//对左右结点处理
		Mirror(root.left);
		Mirror(root.right);
	}
	
	/**
	 * 非递归
	 * 层次遍历，根结点不为null将根结点入队，判断队不为空的时候，
	 * 结点出队，交换该结点的左右孩子，如果左右孩子不为空，将左右孩子入队
	 * @param root
	 */
	public void Mirror2(TreeNode root) {
		if(root==null)return ;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//队列不为空，节点出队，交换该结点的左右子树
			TreeNode root1=queue.poll();
			Swap(root1.left,root1.right);
			if(root1.right!=null) {
				queue.add(root1.right);
			}
			if(root1.left!=null) {
				queue.add(root1.left);
			}
		}
	}

	private void Swap(TreeNode left, TreeNode right) {
		TreeNode temp;
		temp=right;
		right=left;
		left=temp;
	}
}
