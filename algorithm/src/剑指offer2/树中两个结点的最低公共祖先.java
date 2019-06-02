package 剑指offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;
/**
 * https://blog.csdn.net/u013132035/article/details/82115533
 * @author yinjialing
 *
 */
public class 树中两个结点的最低公共祖先 {

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

		TreeNode common=GetLastCommonNode1(node,node3,node6);
		System.out.println(common.val);
	}

	/**
	 * 1.先找到node1，node2的路径
	 * 2.找两个链表的最低公共祖先
	 * @param node
	 * @param node1
	 * @param node2
	 * @return
	 */
	private static TreeNode GetLastCommonNode1(TreeNode node, TreeNode node1, TreeNode node2) {
		List<TreeNode> path1=new ArrayList<TreeNode>();
		List<TreeNode> path2=new ArrayList<TreeNode>();
		getNodePath(path1,node,node1);
		getNodePath(path2,node,node2);
	
		return getLastCommonNode(path1,path2);
	}

	/**
	 * 找两个链表的最低公共祖先
	 * @param path1
	 * @param path2
	 * @return
	 */
	private static TreeNode getLastCommonNode(List<TreeNode> path1, List<TreeNode> path2) {
		int p1=0,p2=0;
		TreeNode last=null;
		while(p1<path1.size()&&p2<path2.size()&&path1.get(p1)==path2.get(p2)) {
			last=path1.get(p1);
			p1++;p2++;
		}
		return last;
	}

	/**
	 * 找到node的路径
	 * 如果其左右子树都都没找到该结点，说明没找到
	 * 如果某结点没找到，移除这个结点，从下一个结点开始找
	 * @param path1
	 * @param node
	 * @param node1
	 */
	private static boolean getNodePath(List<TreeNode> path, TreeNode node, TreeNode node1) {
		if(node==node1)
			return true;
	
		path.add(node);
		boolean leftfound=false,rightFound=false;
		if(node.left!=null)
			leftfound=getNodePath(path,node.left,node1);
		if(node.right!=null)
			rightFound=getNodePath(path,node.right,node1);
		if(!(leftfound||rightFound))
			path.remove(path.size()-1);
		return (leftfound||rightFound);
		
	}

}
