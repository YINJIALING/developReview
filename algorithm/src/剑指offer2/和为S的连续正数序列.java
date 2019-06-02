package 剑指offer2;

import java.util.ArrayList;

public class 和为S的连续正数序列 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res=FindContinuousSequence(9);
		
	}

	/**
	 * 初始化两个指针small,big
	 * 因为是连续且至少有2个数，所以big最大等于(1+s)/2
	 * @param sum
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		
		int small=1,big=2,curSum=small+big,middle=(1+sum)/2;
		while(small<middle) {
			if(curSum==sum) {
				handleList(res,small,big);
			}
			while(small<middle&&curSum>sum) {
				curSum-=small;
				small++;
				if(curSum==sum)
					handleList(res,small,big);
			}
			big++;
			curSum+=big;
		}
		return res;
	}

	/**
	 * 将small到big的数添加到结果集中
	 * @param res
	 * @param small
	 * @param big
	 */
	private static void handleList(ArrayList<ArrayList<Integer>> res, int small, int big) {
		ArrayList<Integer> tmp=new ArrayList<>();
		for(int i=small;i<=big;i++) {
			tmp.add(i);
			System.out.print(i+",");
		}
		System.out.println();
		res.add(tmp);
	}

}
