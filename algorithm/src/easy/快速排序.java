package easy;

public class 快速排序 {

	public static void main(String[] args) {
		int a[] = { 3, 4, 1, 6, 5, 3, 2, 9 };
		quickSort(a, 0, a.length - 1);
		print(a);
	}
	
	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	/**
	 * 每次只固定一个数的位置的如：3, 4, 1, 6, 5, 3, 2, 9 ,key=3, 经过一次partiton的过程1，2，2，3，3，6，5，9。使3前面都是小于3的数，3后面都是大于3的数。返回3的位置
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partiton(int a[], int low, int high) {
		int key = a[low];
		while (low < high) {
			if (a[high] < key) {
				a[low] = a[high];
			}
			while (a[high] >= key && low < high) {
				high--;
			}
			
			if (a[low] > key) {
				a[high] = a[low];
			}
			while (a[low] <= key && low < high) {
				low++;
			}
			
		}
		a[high] = key;
		print(a);
		return high;	
	}

	/**
	 * 使前半部分和后半部分都有序
	 * @param a
	 * @param low
	 * @param high
	 */
	private static void quickSort(int a[], int low, int high) {
		if (low >= high)
			return;
		int index = partiton(a, low, high);//确定一个元素的位置
		quickSort(a, low, index - 1);
		quickSort(a, index + 1, high);
	}

}
