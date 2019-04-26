package leetcode;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class 二叉树展开为链表 {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode root2=new TreeNode(2);
		TreeNode root3=new TreeNode(5);
		TreeNode root4=new TreeNode(3);
		TreeNode root5=new TreeNode(4);
		TreeNode root6=new TreeNode(6);
		root.left=root2;
		root.right=root3;
		root2.left=root4;
		root2.right=root5;
		root3.right=root6;
		flatten2(root);
		while(root!=null) {
			System.out.print(root.val+",");
			root=root.right;
		}
	}

	public static void flatten(TreeNode root) {
		if(root==null)return ;
		List<TreeNode> list=new ArrayList<>();
		TreeNode cur=root;
		getPreOrder(list,cur);
		int i=1;
		//根据前序遍历,构建链表
		while(i<list.size()) {
			cur.left=null;//注意要把左节点置为null
			cur.right=list.get(i);
			cur=cur.right;
			i++;
		}
	}

	//先前序遍历
	private static void getPreOrder(List<TreeNode> list, TreeNode root) {
		if(root==null)
			return;
		list.add(root);
		getPreOrder(list,root.left);
		getPreOrder(list,root.right);
	}
	
	//不修改二叉树结构
	public static void flatten2(TreeNode root) {
		flatten2Core(root,null);
	}
	/**
	 * if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left!=null && root.right != null){//左右子树都不为空
            TreeNode left = root.left;
            while(left.right !=null){
                left = left.right;  //将左子树遍历到最后一个子叶
            }
            left.right = root.right; //将右子树放到左子树的末尾
            root.right = root.left; //将左子树放到右子树
            root.left = null;
        }else if(root.left!=null){//左子树不为空，右子树为空
            root.right = root.left; //将左子树放到右子树
            root.left = null;   //左子树变为null
        }
	 */

	/**
	 * 
	 * @param node 当前节点
	 * @param last 最后一个节点
	 */
	private static void flatten2Core(TreeNode node, TreeNode last) {
		if(node==null)
			return;
		//是叶节点，不做其他处理
		if(node.left==null&&node.right==null) {
			last=node;
			return;
		}
		//备份左右指针
		TreeNode left=null;
		TreeNode right=null;
		//左右子树的最后一个节点
		TreeNode left_last=null;
		TreeNode right_last=null;
		//若有左子树，递归的将左子树转化为单链表
		if(left!=null) {
			left=(TreeNode) node.left.clone();
			flatten2Core(left,left_last);
			node.left=null;
			node.right=left;
			last=left_last;//将该节点的last保存为左子树的last
		}	
		//若有左子树，递归的将右子树转化为单链表
		if(right!=null) {
			right=(TreeNode) node.right.clone();
			flatten2Core(right,right_last);
			//若node找到左子树最后一个节点(有左子树)
			if(left_last!=null) {
				left_last.right=right;
			}
		
			last=right_last;
		}
		
	}

}
