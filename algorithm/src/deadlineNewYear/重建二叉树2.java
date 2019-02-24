package deadlineNewYear;

public class 重建二叉树2 {
	 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 if(pre==null&&in==null)
			 return null;
	      return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
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
	
}
