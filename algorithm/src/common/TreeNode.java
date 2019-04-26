package common;

public class TreeNode implements Cloneable{
public int val;
public TreeNode left=null;
public TreeNode right=null;
public TreeNode(int val) {
	super();
	this.val = val;
}
public Object clone() {
	if(this!=null) {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	else
		return null;
}

}
