package easy;

import java.util.ArrayList;
import java.util.List;

public class 加一 {

	public static void main(String[] args) {
		//new int[]{3, 1, 2, 6, 4, 2}
		print(plusOne(new int[]{1,2,3}));
		print(plusOne(new int[]{9,9,9}));
		print(plusOne(new int[]{9,8,7,6,5,4,3,2,1,0}));
	}
	
	 public static int[] plusOne(int[] digits) {
	     if(digits==null||digits.length==0)return null;
	     
	     List<Integer> list=new ArrayList<>();
	     
	     //一个代表是否需要进位
	     list.add(0, 0);
	     for(int i:digits) {
	    	 list.add(i); 
	     }
	     int length=list.size()-1;
	     
	     //如果最后一位是9，需要迭代向前进位
	     while(list.get(length)==9&&length>0) {
	    	 list.set(length, 0);
	    	 length--;
	     }
	     
	     //进位完成，若进到首位，需向前扩一位；否则直接+1
	     if(length>0) 
	    	 list.set(length, list.get(length)+1);
	     else
	    	 list.set(length, 1);
	     
	     //如果第一位是0说明没向前进位，直接去掉即可；否则说明向前进位了，第1位是1
	     if(list.get(0)==0)list.remove(0);

	    int[] res=new int[list.size()];
	    for(int i=0;i<res.length;i++)
	    	res[i]=list.get(i);
	    return res;
	 }
	 
	 private static void print(int a[]) {
		 for(int i:a) {
			 System.out.print(i+" ");
		 }
		 System.out.println();
	 }

}
