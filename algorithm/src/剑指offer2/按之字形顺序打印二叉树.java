package 剑指offer2;

import java.util.ArrayList;
import java.util.Stack;

import common.TreeNode;

public class 按之字形顺序打印二叉树 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
	
		ArrayList<ArrayList<Integer>> res=Print(node);
		for(ArrayList list:res) {
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+",");
			}
			System.out.println();
		}
	}
	/**
	 * 2个栈
	 * 当遍历1时，把2,3存入stack0
	 * 从stack0中弹出3，把3的子树存入stack1
	 * 当stack0为空的时候，从stack1弹出，并将其子树存入stack0
	 * @param pRoot
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		ArrayList<Integer> tmp=new ArrayList<>();
		if(pRoot==null)return res;
		int current=0;
		Stack[] level=new Stack[2];
		level[0]=new Stack<>();
		level[1]=new Stack<>();
		level[0].add(pRoot);
		while(!level[0].isEmpty()||!level[1].isEmpty()) {
			TreeNode node=(TreeNode) level[current].pop();
			tmp.add(node.val);
			if(current==0) {
				if(node.left!=null)
					level[1].add(node.left);
				if(node.right!=null)
					level[1].add(node.right);
			}else {
				if(node.right!=null)
					level[0].add(node.right);
				if(node.left!=null)
					level[0].add(node.left);
				
			}
			
			if(level[current].isEmpty()) {
				res.add(new ArrayList<>(tmp));
				tmp.clear();
				
				current=1-current;
			}
		}
			
		
		return  res;
    }
	


}