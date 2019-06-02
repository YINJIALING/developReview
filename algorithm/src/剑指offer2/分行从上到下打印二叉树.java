package 剑指offer2;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class 分行从上到下打印二叉树 {

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
		PrintFromTopToBottom(node);

	}

	/**
	 *  初始化为nextPrinted=0;toBePrinted=1
	 *  每推入一个左右节点，nextPrinted++
	 *  当toBePrinted==0空行，并让toBePrinted=nextPrinted；
	 * @param node
	 */
	private static void PrintFromTopToBottom(TreeNode node) {
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(node);
		//nextPrinted在下一层还没打印的节点数，toBePrinted在当前还没打印的节点数
		int nextPrinted=0,toBePrinted=1;
		while(!queue.isEmpty()) {
			TreeNode tmp=queue.poll();
			toBePrinted--;
			System.out.print(tmp.val+",");
			
			if(tmp.left!=null) {
				nextPrinted++;
				queue.add(tmp.left);
			}	
			if(tmp.right!=null) {
				queue.add(tmp.right);
				nextPrinted++;
			}
			if(toBePrinted==0) {
				System.out.println();
				toBePrinted=nextPrinted;
				nextPrinted=0;
				
			}
					
		}
		
	}

}
