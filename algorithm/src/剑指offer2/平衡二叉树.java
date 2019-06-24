package 剑指offer2;

import common.TreeNode;

public class 平衡二叉树 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(11);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		System.out.println(IsBalanced_Solution2(node));
	}

	/**
	 * 每个节点的左右子树深度相差不超过1
	 * 对于root,计算左子树的长度和右子树的长度，求diff, 如果diff不超过1，
	 * 再依次计算其左子树和右子树是否是否是平衡的
	 * 
	 * 缺点：一个节点会被遍历多次
	 * @param root
	 * @return
	 */
	public static boolean IsBalanced_Solution(TreeNode root) {
		if(root==null)return true;
		int left=TreeDepth(root.left);
		int right=TreeDepth(root.right);
		int diff=left-right;
		if(diff<-1||diff>1)
			return false;
		return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static boolean IsBalanced_Solution2(TreeNode root) {
		int depth=0;
		return IsBalanced_Solution(root,depth);
		
	}
	/**
	 * 遍历某节点的左右子节点之后，根据左右子节点的深度差diff是否不超过1，判断该节点以及子树是否平衡
	 * @param root
	 * @param depth
	 * @return
	 */
	private static boolean IsBalanced_Solution(TreeNode root, int depth) {
		if(root==null) {
			depth=0;
			return true;
		}
		int left=0,right=0;
		if(IsBalanced_Solution(root.left,left)&&
				IsBalanced_Solution(root.right,right)) {
			int diff=left-right;
			if(!(diff>1||diff<-1)) {
				depth=1+Math.max(left, right);
				return true;
			}
				
		}
		return false;
		
	}

	/**
	 * 如果root为空，返回0
	 * 如果root非空，计算左节点的长度和右节点的长度，返回两个值中的最大值并加1
	 * @param root
	 * @return
	 */
	public static int TreeDepth(TreeNode root) {
		if(root==null)return 0;
		
		int 	left=TreeDepth(root.left);
		int	right=TreeDepth(root.right);
		
		return Math.max(left, right)+1;
	}

}
