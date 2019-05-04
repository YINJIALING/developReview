package 剑指offer2;

public class 数组中出现次数超过一半的数字 {

	public static void main(String[] args) {
//		System.out.println(MoreThanHalfNum_Solution(new int[] {1,2,3,2,2,2,5,4,2}));
		System.out.println(MoreThanHalfNum_Solution2(new int[] {1,2,3,2,2,2,5,4,2}));

	}

	/**
	 *  1.基于partition
	 *  改变了数组
	 * @param array
	 * @return
	 */
	public static int MoreThanHalfNum_Solution(int[] array) {
		int left=0,right=array.length-1,mid=array.length>>1;
		int index=partition(array,left,right);
		//找到中位数的坐标
		while(index!=mid) {
			if(index<mid) {
				right=index-1;
				index=partition(array,left,right);
			}	
			else {
				left=index+1;
				index=partition(array,index+1,right);
			}
				
		}
		return array[mid];
			}

	private static int partition(int[] array, int left, int right) {
		if(left<0||right>=array.length)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int key=array[left],initLeft=left;
		while(left<right) {
			while(array[right]>=key&&left<right)
				right--;
			while(array[left]<=key&&left<right)
				left++;
			if(left<right&&left<array.length-1&&right>=0)
				swap(left,right,array);
		}
		swap(right,initLeft,array);
		return right;
	}

	private static void swap(int left, int right, int[] array) {
		System.out.println("left:"+left+",right:"+right);
		int tmp=array[right];
		array[right]=array[left];
		array[left]=tmp;
	}
	
	/**
	 * 1.先找出根据规则数组中出现次数超过一半的数字 
	 * 2.验证该数字是否是出现次数超过一半的数字 
	 * @param array
	 * @return
	 */
	public static int MoreThanHalfNum_Solution2(int[] array) {
		int result=array[0],times=1;
		if(checkInvalidArray(array,array.length))
			return 0;
		
		for(int i=1;i<array.length;i++) {
			if(array[i]==result)
				times++;
			else if(times==0) {
				times=1;
				result=array[i];
			}else {
				times--;
			}
		}
		if(!checkMoreThanHalf(array,array.length,result))
			result=0;
		return result;
	}

	private static boolean checkInvalidArray(int[] array, int length) {
		boolean inputInvalid=false;
		if(array==null||length<=0)
			inputInvalid=true;
		return inputInvalid;
	}

	//验证该数字是否是出现次数超过一半的数字 
	private static boolean checkMoreThanHalf(int[] array, int length, int result) {
		int times=0;
		for(int i=0;i<length;i++) {
			if(result==array[i])times++;
		}
		boolean isMoreThanHalf=true;
		if(times*2<=length)
			isMoreThanHalf=false;
		return isMoreThanHalf;
	}

}
