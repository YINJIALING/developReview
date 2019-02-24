package deadlineNewYear;

public class 序列化二叉树 {

	// 输出前序遍历结果
	String Serialize(TreeNode root) {
		StringBuffer s=new StringBuffer();
		if(root==null) {
			s.append("#,");
			return s.toString();
		}
		s.append(root.val+",");
		s.append(Serialize(root.left));
		s.append(Serialize(root.right));
		return s.toString();
	}
	int index=0;

	//根据遍历序列转为二叉树,并返回根结点
	TreeNode Deserialize(String str) {
		if(str==null||str.length()==0)
			return null;
		String[] seq=str.split(",");
		TreeNode root=DeserializeCore(null,seq);
		return root;
	}

	private TreeNode DeserializeCore(TreeNode z, String[] seq) {
		if(seq[index].equals("#")) {
			index++;
			return null;
		}
		z=new TreeNode(Integer.parseInt(seq[index]));
		index++;
		z.left=DeserializeCore(z.left,seq);
		z.right=DeserializeCore(z.right,seq);
		return z;
	}
}
