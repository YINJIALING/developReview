package deadlineNewYear;

public class 重建二叉树 {

	public static void main(String[] args) {

	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0 || in == null || pre == null || in.length != pre.length)
			return null;
		try{
			return reConstructBinaryTree(pre, 0, pre.length - 1,in, 0, in.length - 1);
		}catch(Exception e) {
			return null;
		}
		
	}

	/**
	 * @param pre
	 * @param in
	 * @param preStart
	 * @param preEnd
	 * @param inStart
	 * @param inEnd
	 * **/
	private TreeNode reConstructBinaryTree(
	        int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
	        if(startPre>endPre||startIn>endIn){
	            return null;
	        }
	        //前序遍历的第一个数字是根节点的值
	        TreeNode root = new TreeNode(pre[startPre]);
	        //遍历中序数组，找到根节点的位置,创建左右子树
	        for(int i = startIn;i <=endIn; i++){
	            if(in[i]==pre[startPre]){
	                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
	                root.right = reConstructBinaryTree(pre,startPre+i+1-startIn,endPre,in,i+1,endIn);
	            }
	        }
	        return root;
	    }

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		super();
		this.val = val;
	}

}
