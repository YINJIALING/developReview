package foreigncompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		Combinations combinations=new Combinations();
		combinations.combinations(new ArrayList<>(), Arrays.asList(1,2,3,4), 2);
	}
	
	/**
	 * 从一个数字中找到两个元素，如1,2,3,4；n=2
	 * 1,2;1,3;1,4;2,3;2,4;3,4
	 * @param data
	 * @param n
	 */
	private void combinations(List<Integer> selected,List<Integer> data,int n) {
		if(n==0) {
			//output the empty list
			for(int index:selected) {
				System.out.print(index+" ,");
			}
			System.out.println();
			return;
		}
		if(data.isEmpty())return;
			
		//select element 0
		selected.add(data.get(0));
		combinations(selected,data.subList(1, data.size()),n-1);
		
		//unselect element 0
		selected.remove(selected.size()-1);
		combinations(selected,data.subList(1, data.size()),n);
	}

}
