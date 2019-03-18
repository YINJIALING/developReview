package foreigncompany;

import java.util.Arrays;

//树遍历函数
public class TreeTraversal {
	// 前序：先根节点，再左，最后右
	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.getValue() + ",");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	// 中序：先左再跟节点，最后右
	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.getLeft());
		System.out.print(root.getValue() + ",");
		inOrder(root.getRight());
	}

	// 后序：先左，再右最后根节点
	public static void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getValue() + ",");
	}

	public static void main(String[] args) {
		// a,b,d,e,g,c,f
		TreeNode root = new TreeCreator().createSampleTree(Arrays.asList('a', 'b', 'd', 'e', 'g', 'c', 'f'));
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		postOrder(new TreeCreator().createTree("ABDEGCF", "DBGEACF"));
	}

}
