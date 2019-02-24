package deadlineNewYear;

public class 数字在排序数组中出现的次数 {

	public static void main(String[] args) {
		int[] array= {1,2,2,3,44};
		System.out.println(GetNumberOfK(array,2));
	}
	public static int GetNumberOfK(int [] array , int k) {
	   if(array==null||array.length==0)
		   return 0;
	   int count=0;
	   for(int i=0;i<array.length;i++) {
		   if(k==array[i]) {
			   count++;
			   //如果下一个不等于前一个就跳出循环
			   if(i!=array.length-1&&array[i]!=array[i+1]) {
				   break;
			   }
		   }
	   }
	   return count;
    }

}
