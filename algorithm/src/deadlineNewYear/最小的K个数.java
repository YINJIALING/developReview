package deadlineNewYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最小的K个数 {

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		List<Integer> list = GetLeastNumbers_Solution(input, 10);
		printList(list);
	}

public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k)
	{
		List<Integer> list=new ArrayList<>();;
       if(k<=0||input==null||input.length==0||input.length<k) 
    	   	return (ArrayList<Integer>) list;
       Arrays.sort(input);//排序
      for(int i=0;i<k;i++)
    	  list.add(input[i]);
      return (ArrayList<Integer>) list; 
    }
	
	private static void printList(List<Integer> list) {
		for(Integer index:list)
			System.out.print(index);
		System.out.println();
	}

}
