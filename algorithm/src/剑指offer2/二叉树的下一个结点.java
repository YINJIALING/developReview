package 剑指offer2;

/**
 * https://blog.csdn.net/shansusu/article/details/51049046
 * 
 * @author yinjialing
 *
 */
public class 二叉树的下一个结点 {

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode('a');
		TreeLinkNode root1 = new TreeLinkNode('b');
		TreeLinkNode root2 = new TreeLinkNode('c');
		TreeLinkNode root3 = new TreeLinkNode('d');
		TreeLinkNode root4 = new TreeLinkNode('e');
		TreeLinkNode root5 = new TreeLinkNode('h');
		TreeLinkNode root6 = new TreeLinkNode('i');
		TreeLinkNode root7 = new TreeLinkNode('f');
		TreeLinkNode root8 = new TreeLinkNode('g');
		// TreeLinkNode root9=new TreeLinkNode('h');
		root.left = root1;
		root.right = root2;
		root1.next = root;
		root2.next = root;
		root1.left = root3;
		root1.right = root4;
		root3.next = root1;
		root4.next = root1;
		root4.left = root5;
		root4.right = root6;
		root5.next = root4;
		root6.next = root4;
		root2.left = root7;
		root2.right = root8;
		root7.next = root2;
		root8.next = root2;
		TreeLinkNode res = GetNext(root7);
		System.out.println(res.val);
		inOrder(root);
	}

	private static void inOrder(TreeLinkNode head) {
		if (head == null)
			return;
		inOrder(head.left);
		System.out.print(head.val + ",");
		inOrder(head.right);
	}

	/**
	 * 1. 该点有右子树，返回其右子树的最左节点
	 *  2. 接下来讨论该点没有右子树的情况 如果有父节点且该点是父节点的左节点，返回它的父节点
	 * 如果该点是父节点的右节点，沿着父节点一直向上遍历，直到找到一个是它父节点的左节点的节点，返回其父节点
	 * 两种情况合而为一
	 * 
	 * @param pNode
	 * @return
	 */
	public static TreeLinkNode GetNext(TreeLinkNode pNode) {
		TreeLinkNode cur, tmp = null;
		// 该点有右子树，返回其右子树的最左节点
		if (pNode.right != null) {
			cur = pNode.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		} else {
			// 沿着父节点一直向上遍历，直到找到一个是它父节点的左节点的节点，返回其父节点
			TreeLinkNode parentNode = pNode.next, tmpNode = pNode;
			while (parentNode != null) {
				if (parentNode.left == tmpNode) {
					return parentNode;//找到一个是它父节点的左节点的节点
				}
				tmpNode = parentNode;
				parentNode = parentNode.next;
			}
			if (parentNode == null)
				return null;//没找到
			return parentNode;
		}

	}

}

class TreeLinkNode {
	char val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null; // 指向父节点

	TreeLinkNode(char val) {
		this.val = val;
	}
}