package deadlineNewYear;

import java.util.ArrayList;
import java.util.LinkedList;

public class 从上往下打印二叉树 {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res=new ArrayList<>();
		if(root==null)return res;
		LinkedList<TreeNode> queue=new LinkedList<>();
		TreeNode cur=null;
		queue.offer(root);
		while(!queue.isEmpty()) {
			cur=queue.poll();
			res.add(cur.val);
			if(cur.left!=null)
				queue.offer(cur.left);
			if(cur.right!=null)
				queue.offer(cur.right);
		}
		return res;
	}
}
