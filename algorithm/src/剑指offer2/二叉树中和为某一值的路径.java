package 剑指offer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class 二叉树中和为某一值的路径 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode root1 = new TreeNode(5);
		TreeNode root2 = new TreeNode(12);
		TreeNode root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(7);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		FindPath(root, 22);
	}


	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root==null)
			return res;
		FindPathCore(root, target, res, 0, new ArrayList<>());
		return res;
	}

	/**
	 * 
	 * @param root root结点
	 * @param target
	 * @param res 结果集
	 * @param curSum 当前结果
	 * @param arrayList 当前结果对应的数字
	 */
	private static void FindPathCore(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, int curSum,
			ArrayList arrayList) {
		arrayList.add(root.val);
		curSum += root.val;
		if (curSum == target && root.left == null && root.right == null) {
			print(arrayList);
			res.add(new ArrayList<>(arrayList));
			
		}
		if (root.left != null)
			FindPathCore(root.left, target, res, curSum, arrayList);
		if (root.right != null)
			FindPathCore(root.right, target, res, curSum, arrayList);
		arrayList.remove(arrayList.size() - 1);
		curSum -= root.val;
	}

	@SuppressWarnings("rawtypes")
	private static void print(ArrayList<Integer> arrayList) {
		for (Integer index : arrayList)
			System.out.print(index + ",");
		System.out.println();
	}

}
