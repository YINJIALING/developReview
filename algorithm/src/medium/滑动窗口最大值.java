package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 滑动窗口最大值 {

	public static void main(String[] args) {
//		print(maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7},3));
//		print(maxSlidingWindow(new int[] {1},1));
		print(maxSlidingWindow(new int[] {9,10,9,-7,-4,-8,2,-6},5));
	}

	private static void print(int[] maxSlidingWindow) {
		for(int index:maxSlidingWindow)
			System.out.print(index+" ");
		System.out.println();
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n=nums.length;
		if(n==0)return new int[n];
		int[] res=new int[n-k+1];
		Queue<Integer> heap=new PriorityQueue<>(k,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {//最大优先队列
				
				return o2.compareTo(o1);
			}
		});
		int j=0;
		for(int i=0;i<n-k+1;i++) {
			int count=0;
			while(count<k) {
				heap.add(nums[i+count]);
				count++;
			}
			
			res[j++]=heap.peek();
			heap.clear();
			
		}
		return res;
		
	}
}
