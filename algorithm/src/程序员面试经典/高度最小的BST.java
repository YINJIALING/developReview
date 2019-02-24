package 程序员面试经典;

public class 高度最小的BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 完全二叉树的性质：2^(h-1) - 1 < n <= 2^h - 1
	// 由上述不等式可知： h>=log2^(n+1)=log(n+1)/log2;
	// java中的log是以e为底数
	public int buildMinimalBST(int[] vals) {
		if(vals==null||vals.length==0)
			return 0;
        int number=vals.length;
        return (int) Math.ceil((Math.log(number+1)/Math.log(2)));
        //Math.ceil是向上取整；Math.floor向下取整；Math.round四舍五入
    }

}
