package deadlineNewYear;

import java.util.ArrayList;
import java.util.List;

public class 和为S的连续正数序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		if (sum<=2)
			return list;
		int start=1,end=2;
		while(start!=(sum+1)>>2) {
			int currentSum=sumsOfList(start,end);
			if(currentSum==sum) {
				ArrayList<Integer> curList=new ArrayList<>();
				for(int i=start;i<=end;i++) {
					curList.add(i);
				}
				list.add(curList);
				start++;
				end++;
			}else if(currentSum<sum) {
				end++;
			}else {
				start++;
			}
		}
		return list;
	}

	private int sumsOfList(int start, int end) {
		int sum=0;
		for(int i=start;i<=end;i++) {
			sum+=i;
		}
		return sum;
	}

}
