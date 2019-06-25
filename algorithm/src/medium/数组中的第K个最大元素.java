package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
//时间复杂度 O(NlogK)，空间复杂度 O(K)
public class 数组中的第K个最大元素 {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] {3,2,1,5,6,4},2));
	}

	public static int findKthLargest(int[] nums, int k) {
		Queue<Integer> heap=new PriorityQueue<>(k,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {//实现一个最小优先队列
				return o1.compareTo(o2);
			}
		});
		for(int index:nums) {
			if(heap.size()<k) {
				heap.add(index);
			}else {
				if(heap.peek()<index) {
					heap.poll();
					heap.add(index);
				}
					
			}
			
		}
		return heap.peek();
	}

}
