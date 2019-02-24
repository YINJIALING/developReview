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
	private void preOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
	
			preOrderTraverse(node.left);
	
			preOrderTraverse(node.right);
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
		if (node == null)
			return;
		if (node.left != null)
			preOrderTraverse(node.left);
		System.out.print(node.val + " ");
		if (node.right != null)
			preOrderTraverse(node.right);
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
	private void postOrderTraverse(TreeNode node) {
		if (node == null)
			return;
			preOrderTraverse(node.left);
		
			preOrderTraverse(node.right);
		System.out.print(node.val + " ");
	}
	
	// 后序遍历--非递归
	/**
	 * 1.将所有根结点的所有左结点入栈，将栈顶出栈
	 * 2.将该结点的右孩子入栈，扫描右孩子的所有左结点入栈。当一个结点的左右孩子都被访问后再访问该结点
	 * 要点：
	 * 用一个初始值为null的结点表示右子树已经被访问过
	 * @param root
	 */
	private void postOrderTraverse2(TreeNode root) {
		TreeNode q = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null)
        {    
            while(root.left!=null)            //先左子树入栈,注意:这里最左节点（叶子）没有入栈，后面才入栈
            {
                stack.push(root);
                root = root.left;
            }
            while(root.right==null || root.right ==q )
            {            
                System.out.print(root.val);   //当前节点无右孩子或者右孩子已经输出
                q = root;                      //用来记录上一个节点
                if(stack.empty())
                    return ;               //栈为空时，就结束程序
                root = stack.pop();           //节点出栈
            }        
            stack.push(root);           //！1、叶子节点入栈，指向的r.child是null 2、处理右孩子
            root = root.right;
        }
	}

}
