package easy;

public class 二分查找 {

	public static void main(String[] args) {
		二分查找 a=new 二分查找();
		int[] array= {1,2,3,4,5};
		System.out.println(a.binarySearch(array,4));
	}
	
	/**
	 * 找到该值在数组中的下标，否则返回-1
	 * 时间复杂度O(log2n)
	 * @param array
	 * @param key
	 * @return
	 */
	public int binarySearch(int[] array,int key) {
		int left=0;
		int right=array.length-1;
		while(left<=right) {
			int mid=(left+right)>>1;
			if(array[mid]==key)
				return mid;
			else if(array[mid]<key)
				left=mid+1;
			else
				right=mid-1;
		}
		return -1;
	}

}
