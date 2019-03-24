package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 使用优先队列(基于堆的性质)，分为最小优先队列和最大优先队列。最小优先队列，最大元素优先出队
 * 这里使用的是堆顶存的是当前堆中最大元素
 * 
 */
public class 有序矩阵中第K小的元素 {

	public static void main(String[] args) {

		int[][] num= {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(kthSmallest(num,8));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		Queue<Integer> heap=new PriorityQueue<>(k,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
		});
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(heap.size()<k) {
					heap.add(matrix[i][j]);//当前堆大小小于k,给堆添加元素
				}else {//当前堆大小大于k
					if(heap.peek()>matrix[i][j]) {//如果堆顶元素(最大堆)大于当前元素，说明需要更新堆的中元素
						heap.poll();//从堆顶弹出，并把最新的第几小的元素推入堆
						heap.add(matrix[i][j]);
					}
				}
			}
		}
		return heap.peek();
	}

}
