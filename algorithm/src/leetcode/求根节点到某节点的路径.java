package leetcode;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class 求根节点到某节点的路径 {
	static List<TreeNode> res=new ArrayList<>();

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
		List<TreeNode> list=new ArrayList<>();
		
		findPath(node,node8,list);
		System.out.println("_________res______");
		for(TreeNode tmp:res)
			System.out.print(tmp.val+",");
	}

	private static void findPath(TreeNode root, TreeNode target, List<TreeNode> list) {
		if(root==null)return;
		list.add(root);
		System.out.println("had added");
		if(root==target) {
			res=new ArrayList<>(list);
			System.out.println("find");
			return;
		}
		if(root.left!=null)
			findPath(root.left,target,list);
		if(root.right!=null)
			findPath(root.right,target,list);
		list.remove(list.size()-1);
	}

}
