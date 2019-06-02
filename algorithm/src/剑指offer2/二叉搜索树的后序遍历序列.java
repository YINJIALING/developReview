package 剑指offer2;

public class 二叉搜索树的后序遍历序列 {

	public static void main(String[] args) {
//		System.out.println(VerifySquenceOfBST(new int[] {5,7,6,9,11,10,8}));
		System.out.println(VerifySquenceOfBST(new int[] {5,7,6}));
	}

	public static boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence==null||sequence.length==0)
			return false;
		return VerifySquenceOfBST(sequence,0,sequence.length-1);
	}

	/**
	 * 5,7,6,9,11,10,8
	 * 8是root,根据二叉搜索的规则，5-6是root的左半部分，9-10是root的右半部分
	 * 再根据以上规则，判断子数组5,7,6是否满足二叉搜索的规则
	 * @param sequence
	 * @param start
	 * @param end
	 * @return
	 */
	private static boolean VerifySquenceOfBST(int[] sequence,int start, int end) {
		if(start>=end)return true;
		int root=sequence[end];
		//在数组中从start开始寻找，直到发现一个大于root的值跳出
		int i;
		for( i=0;i<end;i++) {
			if(sequence[i]>root)
				break;
		}
		// 在右半边寻找是否有小于root的，如果是小于的，返回false
		int j=i;
		for(j=i;j<end;j++) {
			if(sequence[j]<root)
				return false;
		}
		//判断左边是否符合二叉搜索的树的条件
		boolean left=true;
		if(i>0)
			left=VerifySquenceOfBST(sequence,start,i-1);
		//判断右边是否符合二叉搜索的树的条件
		boolean right=true;
		if(j<end)
			right=VerifySquenceOfBST(sequence,i,j);

		return (left&&right);
	}

}
