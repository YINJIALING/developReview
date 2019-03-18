package foreigncompany;

import java.util.List;

public class TreeCreator {
	//a,b,d,e,g,c,f
	public TreeNode createSampleTree(List<Character> list) {
		int count=0;
		TreeNode root=new TreeNode(list.get(count++));
		root.setLeft(new TreeNode(list.get(count++)));
		root.getLeft().setLeft(new TreeNode(list.get(count++)));
		root.getLeft().setRight(new TreeNode(list.get(count++)));
		root.getLeft().getRight().setLeft(new TreeNode(list.get(count++)));
		root.setRight(new TreeNode(list.get(count++)));
		root.getRight().setRight(new TreeNode(list.get(count++)));
		return root;
	}
	
	// 根据前序和中序创建一棵树
	public TreeNode createTree(String preOrder,String inOrder) {
		if(preOrder.isEmpty())return null;
		
		char rootValue=preOrder.charAt(0);// root
		int rootIndex=inOrder.indexOf(rootValue);
		TreeNode root=new TreeNode(rootValue);
		root.setLeft(createTree(preOrder.substring(1,rootIndex+1),inOrder.substring(0, rootIndex)));
		root.setRight(createTree(preOrder.substring(rootIndex+1),inOrder.substring( rootIndex+1)));
		return root;
	}
}
