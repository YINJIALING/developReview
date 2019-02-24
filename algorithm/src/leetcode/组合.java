package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combine(int n, int k) {
		int i=1;
		List<List<Integer>> res=new ArrayList<>();
		while(i<=n) {
			List<Integer> list=new ArrayList<>();
			int j=i+1;
			list.add(i);
			while(j<=n) {
				
			}
			
			if(!list.contains(i)) {
				
				if(list.size()==k) {
					res.add(list);
				}else {
					
				}
			}
		}
	}

}
