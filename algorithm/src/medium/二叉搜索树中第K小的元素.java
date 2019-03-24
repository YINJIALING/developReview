package medium;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;
import medium.test.TreeNodeCreator;

/**
 * 二叉搜索树的中序遍历就是升序输出
 * 
 * @author yinjialing
 *
 */
public class 二叉搜索树中第K小的元素 {

	public static void main(String[] args) {
		TreeNode root=new TreeNodeCreator().creator();
		System.out.println(kthSmallest(root,1));
	}

	//所以只要返回中序遍历的第k-1个元素即可
	public static int kthSmallest(TreeNode root, int k) {
		List<Integer> list=new ArrayList<>();
		InOrder( root,list,k);
		return list.get(k-1);
	}

	private static void InOrder(TreeNode root, List<Integer> list,int k) {
		if(root==null||(!list.isEmpty()&&list.size()==k))
			return ;
		
		InOrder(root.left,list,k);
		list.add(root.val);
		InOrder(root.right,list,k);
	}

}
