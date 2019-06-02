package 剑指offer2;

public class 数组中的逆序对 {

	public static void main(String[] args) {
		System.out.println(InversePairs(new int[] {7,5,6,4}));

	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int InversePairs(int[] array) {
		if(array==null||array.length==0)
			return 0;
		return InversePairs(array,0,array.length-1);
	}

	/*
	 * 在归并排序的过程计算逆序对
	 */
	private static int InversePairs(int[] array, int start, int end) {
		if(start==end)return  0;
		int mid=(start+end)>>1;
		int left_count=InversePairs(array,start,mid);
		int right_count=InversePairs(array,mid+1,end);
		int i=mid,j=end;
		int[] copy=new int[end-start+1];
		int copy_index=end-start;
		int count=0;
		while(i>=start&&j>=mid+1) {
			if(array[i]>array[j]) {
				copy[copy_index--]=array[i--];
				count+=(j-mid);
			}else {
				copy[copy_index--]=array[j--];
			}
			
		}
		while(i>=start)
			copy[copy_index--]=array[i--];
		
		while(j>=mid+1) 
			copy[copy_index--]=array[j--];
		
		i=0;
		while(start<=end) {
			array[start++]=copy[i++];
		}
		return left_count+count+right_count;
	}

}
