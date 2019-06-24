package 剑指offer2;

import java.util.ArrayList;
import java.util.List;

public class 圆圈中最后剩下的数 {

	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(5,3));

	}

	public static int LastRemaining_Solution(int n, int m) {
		if(n<=0||m<=0)return -1;
		List<Integer> list=new ArrayList<>(n);
		for(int i=0;i<n;i++)
			list.add(i);
		int current=0 ;
		while(list.size()!=1) {
			current+=m-1;
			while(current>=0&&current>(list.size()-1))
				current-=list.size();
			list.remove(current);
		}
		return list.get(0);
	}

}
