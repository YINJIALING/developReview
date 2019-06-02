package 剑指offer2;

import java.util.ArrayList;

public class 和为S的两个数字 {

	public static void main(String[] args) {
		 ArrayList<Integer> list=FindNumbersWithSum(new int[] {1,2,4,7,11,15},15);
		 for(Integer index:list)
			 System.out.print(index+",");
	}

	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list=new ArrayList<>();
		int p1=0,p2=array.length-1;
		while(p1<p2) {
			while(p1<p2&&array[p1]+array[p2]>sum)
				p2--;
			while(p1<p2&&array[p1]+array[p2]<sum)
				p1++;
			if(array[p1]+array[p2]==sum) {
				list.add(array[p1]);
				list.add(array[p2]);
				break;
			}
				
		}
		return list;
	}

}
