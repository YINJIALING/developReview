package 剑指offer2;

public class 八个定点的和 {

	public static void main(String[] args) {
		int a[] = {2, 3, 7, 9, 11, 0, 2, 6};
		isFullSort(a);
	}
	private static void isFullSort(int[] a) {
		isFullSort(a,0,a.length);
	}
	/**
	 * 
	 * @param a
	 * @param start 当前需要交换的索引
	 * @param length
	 */
	private static void isFullSort(int[] a, int start, int length) {
		if(start>=length) {
			print(a);
//			if(isCan(a))
//				print(a);
		}
		//将i与start相互交换
		for(int i=start;i<length;i++) {
			swap(a,i,start);
			isFullSort(a,start+1,a.length);//下一个需要交换的索引
			swap(a,i,start);
		}
		
	}
	private static void print(int[] a) {
		for(int index:a)
			System.out.print(index+",");
		System.out.println();
	}
	//判断是否满足限定的条件
	private static boolean isCan(int[] a) {
		if(a[0]+a[1]+a[2]+a[3]==a[4]+a[5]+a[6]+a[7]&&
				a[0]+a[2]+a[4]+a[6]==a[1]+a[3]+a[5]+a[7]&&
				a[2]+a[3]+a[6]+a[7]==a[1]+a[0]+a[5]+a[4])
			return true;
		return false;
	}
	private static void swap(int[] a, int i, int start) {
		int tmp=a[i];
		a[i]=a[start];
		a[start]=tmp;
		
	}

}
