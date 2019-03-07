package medium;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

	public static void main(String[] args) {
		List<List<Integer>> res=combine(4,2);
		for(List<Integer> list:res) {
			list.forEach(str->{
				  System.out.print(str+" ");
				 });
			System.out.println();
		}
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res=new ArrayList<>();
		combineCore(res,new ArrayList<>(),n,k,1);
		return res;
	}

	/**
	 * 
	 * @param res 所有排列的结果集
	 * @param arrayList 当前结果集
	 * @param n 1到n的数
	 * @param k 取k个数
	 * @param indexInN 遍历到n的第几个数
	 * 
	 */
	private static void combineCore(List<List<Integer>> res, List<Integer> arrayList, int n, int k, int indexInN) {
		//递归终止条件
		if(arrayList.size()==k) {
			res.add(new ArrayList(arrayList));
			return ;
		}
		for(int i=indexInN;i<=n;i++) {
			arrayList.add(i);
			combineCore(res,arrayList,n,k,i+1);
			arrayList.remove(arrayList.size()-1);
		}
		
	}
	
}
