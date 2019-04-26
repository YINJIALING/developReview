package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class 路径总和2 {

	public static void main(String[] args) {
		TreeNode node=new TreeNode(5);
		TreeNode node1=new TreeNode(4);
		TreeNode node2=new TreeNode(8);
		TreeNode node3=new TreeNode(11);
		TreeNode node4=new TreeNode(13);
		TreeNode node5=new TreeNode(4);
		TreeNode node6=new TreeNode(7);
		TreeNode node7=new TreeNode(2);
		TreeNode node8=new TreeNode(5);
		TreeNode node9=new TreeNode(1);
		node.left=node1;node.right=node2;
		node1.left=node3;node2.left=node4;node2.right=node5;
		node3.left=node6;node3.right=node7;node5.left=node8;node5.right=node9;
		List<List<Integer>> res=pathSum(node,22);
		System.out.println(res.size());
		
	}

	/**
	 * [1,-2,-3,1,3,-2,null,-1] 2
	 * output:[[-2,1,3]]
	 * expected:[[1,-2,3]]
	 * @param root
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res=new LinkedList<>();
		pathSumCore(root,sum,0,new LinkedList<Integer>(),res);
		return res;
	}

	private static void pathSumCore(TreeNode root, int sum, int path_value, LinkedList arrayList,
			List<List<Integer>> res) {
		if(root==null)return;
		path_value+=root.val;
		arrayList.add(root.val);
		pathSumCore(root.left,sum,path_value,arrayList,res);
		pathSumCore(root.right,sum,path_value,arrayList,res);
		
		//是叶子节点且sum==path_value
		if(root.left==null&&root.right==null&&path_value==sum)
			res.add(new LinkedList<>(arrayList));
		path_value-=root.val;
		arrayList.remove(new Integer(root.val));
	}

}
