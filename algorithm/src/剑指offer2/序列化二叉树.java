package 剑指offer2;

import common.TreeNode;

public class 序列化二叉树 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		node.left = node1;
		node.right = node2;
		
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
//		System.out.println(Serialize(node));
		TreeNode res=Deserialize("5,4,$,3,$,2");
		print(res);

	}
	private static void print(TreeNode res) {
		if(res==null)
			return;
		System.out.print(res.val+",");
		print(res.left);
		print(res.right);
		
	}
	static String Serialize(TreeNode root) {
		StringBuffer str=new StringBuffer();
		Serialize(root,str);
		if(str.length()>1) {
			str.replace(str.length()-1, str.length(), "");
		}
		
		return str.toString();
	}
	static void Serialize(TreeNode root,StringBuffer str) {
		if(root==null) {
			str.append("$,");
			return ;
		}
		str.append(root.val+",");
		Serialize(root.left,str);
		Serialize(root.right,str);
	}
	static int start=-1;
	static TreeNode Deserialize(String str) {
		if(str==null)return null;
		
		String[] c=str.split(",");
		
		return DeserializeCore(c);
	}
	private static TreeNode DeserializeCore(String[] str) {
		start++;
		if(start<str.length&&!str[start].equals("$")) {
			TreeNode root=new TreeNode(Integer.parseInt(str[start]));
			root.left=DeserializeCore(str);
			root.right=DeserializeCore(str);
			return root;
		}
		return null;
			
	}
}
