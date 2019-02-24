package deadlineNewYear;

public class 调整数组顺序使奇数位于偶数前面 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {2,3,7,8,10,5};
		reOrderArray(arr);
	}

	public static void reOrderArray(int[] array) {
		int[] cloneArray=array.clone();
		int head=0;
		for(int i=0;i<cloneArray.length;i++) {
			//奇数放在前面
			if(!judgeOushu(cloneArray[i])) {
				array[head]=cloneArray[i];
				head++;
			}			
		}
		for(int i=0;i<cloneArray.length;i++) {
			//偶数放在后面
			if(judgeOushu(cloneArray[i])) {
				array[head]=cloneArray[i];
				head++;
			}			
		}
		
		print(cloneArray);
		print(array);
	}
	
	/**
	 * 偶数返回true
	 * */
	private static boolean judgeOushu(int number) {
		return (number%2==0);
	}
	
	private static void print(int[] array) {
		for(int index:array)
			System.out.print(index+" ");
		System.out.println();
	}

}
