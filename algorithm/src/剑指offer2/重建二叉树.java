package 剑指offer2;

import common.TreeNode;

public class 重建二叉树 {

	public static void main(String[] args) {
		TreeNode res=reConstructBinaryTree(new int[] {1,2,4,7,3,5,6,8},new int[] {4,7,2,1,5,3,8,6});
		preOrder(res);
	}

	 private static void preOrder(TreeNode res) {
		if(res==null)return;
		System.out.print(res.val+",");
		preOrder(res.left);
		preOrder(res.right);
		
	}
	 private TreeNode reConstructBinaryTree(int[] pre, int[] in, int leftInPre,
				int rightInPre, int leftInIN, int rightInIN) {
	        if(leftInPre>rightInPre)return null;
			TreeNode root=new TreeNode(pre[leftInPre]);
	      int rootIndex=0;
			for(int i = leftInIN;i <=rightInIN; i++){
	            if(in[i]==pre[leftInPre]){
	            		rootIndex=i;
	                
	            }
	        }
			root.left = reConstructBinaryTree(pre,in,leftInPre+1,leftInPre+rootIndex-leftInIN,leftInIN,rootIndex-1);
	        root.right = reConstructBinaryTree(pre,in,leftInPre+rootIndex+1-leftInIN,rightInPre,rootIndex+1,rightInIN);
	      return root;
	    }

	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 if(pre==null||in==null)return null;
		 StringBuffer preStr=new StringBuffer();
		 StringBuffer inStr=new StringBuffer();
		 for(int index:pre) {
			 preStr.append(index);
		 }
		 for(int index:in) {
			 inStr.append(index);
		 }
		 return reConstructBinaryTreeCore(preStr.toString(),inStr.toString());
	 }

	private static TreeNode reConstructBinaryTreeCore(String pre,String in) {
		if(pre.isEmpty())return null;
		char c=pre.charAt(0);
		TreeNode root=new TreeNode(Integer.parseInt(c+""));
		int rootIndex=in.indexOf(c);
		root.left=reConstructBinaryTreeCore(pre.substring(1, rootIndex+1),in.substring(0, rootIndex));
		root.right=reConstructBinaryTreeCore(pre.substring(rootIndex+1),in.substring(rootIndex+1));
		return root;
	}
}
