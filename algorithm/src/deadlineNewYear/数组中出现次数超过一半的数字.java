package deadlineNewYear;

import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution(array));
	}
	 public static int MoreThanHalfNum_Solution(int [] array) {
	      if(array==null||array.length==0)
	    	  return 0;
	      Map<Integer,Integer> map=new HashMap<>();//key:数组中的元素；value:出现的次数
	      for(int i=0;i<array.length;i++) {
	    	  map.put(array[i], map.getOrDefault(array[i], 0)+1);
	      }
	      //再遍历一遍map，return出现一半的数组
	      for(Integer key:map.keySet()) {
	    	  if(map.get(key)>(array.length/2))
	    		  return key;
	      }
	      return 0;
	    }

}
