package 剑指offer2;

import common.TreeNode;

public class 二叉搜索树与双向链表 {

	public static void main(String[] args) {
		TreeNode node=new TreeNode(10);
		TreeNode node1=new TreeNode(6);
		TreeNode node2=new TreeNode(14);
		node.left=node1;node.right=node2;
		TreeNode res=Convert(node);
		while(res!=null) {
			System.out.print(res.val+"->");
			res=res.right;
		}
	}

	public static TreeNode Convert(TreeNode pRootOfTree) {
		//指向结果集的尾节点
		TreeNode pLastNodeInList=null;
		convertTree(pRootOfTree,pLastNodeInList);
		//需要返回头结点，只需要从pLastNodeInList开始返回最前的 left
		TreeNode pHeadOfList=pLastNodeInList;
		while(pHeadOfList!=null&&pHeadOfList.left!=null) {
			pHeadOfList=pHeadOfList.left;
		}
		return pHeadOfList;
	}

	/**
	 * 如果pNode有左子树，反转其左子树成树，将当前左节点的right设为pNode
	 * pLastNodeInList推进1，设为pNode
	 * 如果pNode有右子树，反转其右子树成树
	 * @param pNode
	 * @param pLastNodeInList
	 */
	private static void convertTree(TreeNode pNode, TreeNode pLastNodeInList) {
		if(pNode==null)return;
		TreeNode pCurrent=pNode;
		if(pCurrent.left!=null)
			convertTree(pCurrent.left,pLastNodeInList);
		
		pCurrent.left=pLastNodeInList;
		if(pLastNodeInList!=null)
			pLastNodeInList.right=pCurrent;
		pLastNodeInList=pCurrent;
		
		if(pCurrent.right!=null)
			convertTree(pCurrent.right,pLastNodeInList);
	}

}
