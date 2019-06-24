package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import common.TreeNode;
/**
 * http://www.cnblogs.com/LZYY/p/3454778.html
 * @author yinjialing
 *
 */
public class 二叉树的层次遍历 {

	/**
	 * 使用队列--这个队列感觉是来存根结点，再遍历该根结点的左右子树 先将根结点入队，当前结点是根结点，将其出队并访问；
	 * 如果当前结点的左结点不为空，将左结点入队 如果当前结点的右结点不为空，将右结点入队
	 * 
	 * @param root
	 */
	private void levelItertor(TreeNode root) {
		if (root == null)
			return;
		ArrayList<Integer> res = new ArrayList<>();// 存放结果
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode cur = null;
		queue.offer(root);// 根结点存入队列
		while (!queue.isEmpty()) {
			cur = queue.poll();// 每访问一个将队列中已有结点出队
			res.add(cur.val);
			if (cur.left != null) {
				// 如果当前结点有左结点
				queue.offer(cur.left);
			}
			if (cur.right != null)
				queue.offer(cur.right);
		}
	}
	
	//层次遍历--递归
	 private void levelOrder(TreeNode node) {
		 if(node==null)return ;
		 int depth=depth(node);//求深度
		 
		 for(int i=0;i<=depth;i++) {
			 levelOrder(node,i);
		 }
	 }
	 private int depth(TreeNode node) {
		if(node==null)
			return 0;
		
		int left=depth(node.left);
		int right=depth(node.right);
		return left>right?left+1:right+1;
	}

	private void levelOrder(TreeNode node,int level) {
		 if(node==null||level<1)return ;
		 if(level==1) {
			 System.out.print(node.val+" ");
			 return;
		 }
		//左子树
		 levelOrder(node.left,level-1);
		 //右子树
		 levelOrder(node.right,level-1);
	 }
	 

	// 先序遍历--递归
	private static void preOrderTraverse(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			
			preOrderTraverse(node.left);
	
			preOrderTraverse(node.right);
		}
			
		
	}

	// 先序遍历--非递归
	private void preOrderTraverse2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
       
            stack.push(root);
            while(!stack.empty())
            {
            	TreeNode node = stack.pop();
                System.out.print(node.val);
                if(node.right!=null)         //先把右孩子压入栈，利用下压栈的特性.注意先右后左
                    stack.push(node.right);
                if(node.left!=null)
                    stack.push(node.left);                
            }
        
	}
	// 中序遍历--递归
	private void inOrderTraverse(TreeNode node) {
		if(node!=null) {
			preOrderTraverse(node.left);
			System.out.print(node.val + " ");
			preOrderTraverse(node.right);
		}
	
	}
	
	// 中序遍历--非递归
	/**
	 *  1.访问任一结点，将其非空的左孩子入栈，且左孩子作为当前结点，做相同的处理
	 *  2.若其左孩子为空，输出栈顶元素并进行出栈，访问栈顶元素的右孩子
	 *  3.当栈为空或指向元素=null，结束遍历
	 * @param root
	 */
	private void inOrderTravers2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode node=root;
		while(node!=null||stack.size()>0) {//将所有左孩子压栈
			if(node!=null) {	
				stack.push(node);
				node=node.left;
			}else {
				node=stack.pop();
				System.out.println(node.val);
				node=node.right;
			}
		}
	}

	// 后序遍历--递归
	private static void postOrderTraverse(TreeNode root) {
		if (root != null) {
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
		    System.out.print(root.val+" ");
		  }

		
	}
	
	// 后序遍历--非递归
	/**
	 *  一个栈实现
	 *  h:最近一次弹出并打印的结点c:stack栈顶元素，先不弹出
	 * 1.判断h是否是c的左右孩子结点
	 * 如果不是左孩子也不是右孩子，说明左孩子还没处理，stack推入左孩子
	 * 如果不是右孩子，说明右孩子还没处理，stack推入右孩子
	 * 如果上述都不满足，说明左右孩子没有或处理过，推出c,并打印，令h=c
	 * @param root
	 */
	private static void postOrderTraverse2(TreeNode h) {
		if(h==null)return;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode c=null;
		stack.push(h);
		while(!stack.isEmpty()) {
			c=stack.peek();
			if(c.left!=null&&h!=c.left&&h!=c.right)
				stack.push(c.left);
			else if(c.right!=null&&h!=c.right)
				stack.push(c.right);
			else {
				System.out.print(stack.pop().val+",");h=c;
			}
		}        
	}
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

		postOrderTraverse2(root);
	}

}
