package deadlineNewYear;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class 把二叉树打印成多行 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//非递归--和层次遍历思路基本一样，不同的是这里一层一个list，所以需要计数
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
	   if(pRoot==null) 
		   return res;
	   LinkedList<TreeNode> queue=new LinkedList<>();
	   TreeNode cur=null;
	   queue.offer(pRoot);
	   while(!queue.isEmpty()) {
		   int last=queue.size();//每一层的个数  
		   int count=0;//每一层存储到第几个
		   ArrayList<Integer> curList=new ArrayList<>();
		   while(count<last) {
			   cur=queue.poll();
			   curList.add(cur.val);
			   count++;
			   if(cur.left!=null) {
				   queue.offer(cur.left);
			   }
			   if(cur.right!=null)
				   queue.offer(cur.right);
		   }
		  
		   res.add(curList);
			   
	   }
	   return res;
    }
	
	//递归
	ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		depth(pRoot,1,res);
		return res;
	}
	private void depth(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> res) {
		if(pRoot==null)
			return;
		if(depth>res.size()) {
			res.add(new ArrayList<Integer>());
		}
		res.get(depth-1).add(pRoot.val);
		depth(pRoot.left,depth+1,res);
		depth(pRoot.right,depth+1,res);
	}
}
