package leetcode;

import common.TreeNode;

public class 从前序与中序遍历序列构造二叉树 {

	public static void main(String[] args) {
//		TreeNode node1=new TreeNode(3);
//		TreeNode node2=new TreeNode(9);
//		TreeNode node3=new TreeNode(20);
//		TreeNode node4=new TreeNode(15);
//		TreeNode node5=new TreeNode(7);
//		node1.left=node2;
//		node1.right=node3;
//		node3.left=node4;
//		node3.right=node5;
		TreeNode res=buildTree(
				new int[] {3,9,20,15,7},
				new int[] {9,3,15,20,7});
		print(res);
	}

	private static void print(TreeNode res) {
		if(res==null)return ;
		System.out.print(res.val);
		print(res.left);
		print(res.right);
	}

	/**
	 * 
	 * @param preorder 3,9,20,15,7
	 * @param inorder 9,3,15,20,7
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int len=preorder.length;
		TreeNode root=new TreeNode(-1);
		buildTreeCore(preorder,inorder,0,len,0,len,root);
		return root;
	}

	private static void buildTreeCore(int[] preorder, int[] inorder, int preorderstart,int preorderend,int inorderstart,int inorderend,TreeNode root) {
		if(root==null)return ;
		int index=preorder[preorderstart],inIndex=0;
		root=new TreeNode(index);
		for(int i=0;i<inorder.length;i++) {
			if(inorder[i]==index)
				inIndex=i;
		}
		
		buildTreeCore(preorder,inorder,preorderstart+1,inIndex,preorderstart,inIndex-1,root.left);
		buildTreeCore(preorder,inorder,inIndex+1,preorder.length,index+1,preorder.length,root.right);
		
	}

}
