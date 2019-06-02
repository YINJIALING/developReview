package easy;

public class 堆排序 {
	private static void print(int[] array) {
		for(int i:array) {
			System.out.print(i+",");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] array= {4,6,8,5,9};
		heapSort(array);
		System.out.print("res:");
		print(array);

	}

	/**
	 * 1.构建大根堆
	 * 2.将其与当前0位元素交换，也就是达得到最大值，下次只要令0到最大值前面一个元素自平衡就可以，依次递减，直到只剩下一个元素（就是最小值）
	 * @param array
	 */
	private static void heapSort(int[] array) {
		if(array==null||array.length==0)return;
		buildMaxHeap(array);
		print(array);
		//选择顶，并与第0位元素交换，并且根据堆的性质调整堆，并注意此时堆顶不是最大值
		for(int i=array.length-1;i>=1;i--) {
			swap(array,i,0);
			maxHeap(array,i,0);
		}
		
	}

	//构建从一半开始大根堆，满足a[i]>=a[2i+1]&&a[i]>=a[2i+2]
	private static void buildMaxHeap(int[] array) {
		int half=array.length/2;
		for(int i=half;i>=0;i--) {
			maxHeap(array,array.length,i);
		}
		
	}

	//调整位置使在范围内堆自平衡
	/**
	 * 在left,right，root中寻找最大值，若root是，那么堆不变
	 * 若不是，将当前位置与最大值位置交换（让最大值做root），并调整位置，使之后的元素自平衡
	 * @param array
	 * @param heapSize
	 * @param index
	 */
	private static void maxHeap(int[] array, int heapSize, int index) {
		int left=index*2+1;//左结点坐标
		int right=index*2+2;//右结点坐标
		int largest=index;
		if(left<heapSize&&array[left]>array[index]) {
			largest=left;
		}
		if(right<heapSize&&array[right]>array[largest]) {
			largest=right;
		}
		if(index!=largest) {
			swap(array,index,largest);
			maxHeap(array,heapSize,largest);
		}
	}

	private static void swap(int[] array, int index, int largest) {
		int tmp=array[index];
		array[index]=array[largest];
		array[largest]=tmp;
		
	}

}
