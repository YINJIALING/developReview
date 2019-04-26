package leetcode;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class 二叉树的最近公共祖先 {

	public static void main(String[] args) {
		TreeNode node=new TreeNode(3);
		TreeNode node1=new TreeNode(5);
		TreeNode node2=new TreeNode(1);
		TreeNode node3=new TreeNode(6);
		TreeNode node4=new TreeNode(2);
		TreeNode node5=new TreeNode(0);
		TreeNode node6=new TreeNode(8);
		TreeNode node7=new TreeNode(7);
		TreeNode node8=new TreeNode(4);
		node.left=node1;node.right=node2;
		node1.left=node3;node1.right=node4;node2.left=node5;node2.right=node6;
		node4.left=node7;node4.right=node8;
		TreeNode res=lowestCommonAncestor(node,node1,node8);
		System.out.println(res.val);

	}

	/**
	 * 1.求出较短路径
	 * 2.同时遍历p,q的路径，遍历n个节点，最后一个发现相同的节点，即为最近公共祖先
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	static List<TreeNode> mark_path=new ArrayList<>();
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> path=new ArrayList<>();
		preorder(root,p,path);
		List<TreeNode> node_p_path=new ArrayList<>(mark_path);
		path.clear();
		preorder(root,q,path);
		List<TreeNode> node_q_path=new ArrayList<>(mark_path);
		int path_len=0;//较短路径的长度
		if(node_p_path.size()<node_q_path.size())
			path_len=node_p_path.size();
		else
			path_len=node_q_path.size();
		
		TreeNode result=null;
		for(int i=0;i<path_len;i++) {
			// 一直相等就一直更新
			if(node_p_path.get(i)==node_q_path.get(i))
				result=node_p_path.get(i);//找到最近公共祖先
		}
		return result;
	}

	// 求根节点到某节点的路径
	/**
	 * 
	 * @param node
	 *            正在遍历的节点
	 * @param search
	 *            待搜索的节点
	 * @param path
	 *            遍历时的节点路径栈
	 */
	private static void preorder(TreeNode node, TreeNode search, List<TreeNode> path) {
		if(node==null)
			return;
		path.add(node);
		if(node==search) {
			mark_path=new ArrayList<>(path);
			return;
		}
			
		if(node.left!=null)
			preorder(node.left,search,path);
		if(node.right!=null)
			preorder(node.right,search,path);
		path.remove(path.size()-1);
	}

}
