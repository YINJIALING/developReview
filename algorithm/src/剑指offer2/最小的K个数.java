package 剑指offer2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 最小的K个数 {

	public static void main(String[] args) {
		ArrayList<Integer> list=GetLeastNumbers_Solution2(new int[] {4,5,1,6,2,7,8,3},4);
		for(Integer index:list)
			System.out.print(index+",");
	}

	/**
	 * 基于partition，参考数组中出现次数超过一半的数字
	 * 最小的k个数，也就是求当index=k-1时，此时input[0]-input[k-1]
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		int n=input.length;
		ArrayList<Integer> output=new ArrayList<>();
		if(input==null||k<=0||k>n||n==0)
			return output;
		int start=0,end=input.length-1;
		int index=partition(input,start,end);
		while(index!=k-1) {
			if(index>k-1) {
				partition(input,start,index-1);
			}else {
				partition(input,index+1,end);
			}
		}
		for(int i=0;i<=k-1;i++) {
			output.add(input[i]);
		}
		return output;
	}
	//最大堆
	/**
	 * 1.创建一个大小为k的容器来保存结果
	 * 2.如果容器未满，往里面直接添加
	 * 2.容器已满，比较容器顶元素与当前元素，如果>,将容器顶元素更新为当前元素，否则跳过当前元素
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		int n=input.length;
		ArrayList<Integer> output=new ArrayList<>();
		if(input==null||k<=0||k>n||n==0)
			return output;
		Queue<Integer> queue=new PriorityQueue<>(k,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
		});
		for(int i=0;i<input.length;i++) {
			if(queue.size()<k)
				queue.add(input[i]);
			else if(queue.peek()>input[i]) {
				queue.poll();
				queue.add(input[i]);
			}
		}
		while(!queue.isEmpty())
			output.add(queue.poll());
		return output;
	}

	private static int partition(int[] input, int start, int end) {
		int key=input[start],initStart=start;
		while(start<end) {
			while(input[end]>=key&&start<end)
				end--;
			while(input[start]<=key&&start<end)
				start++;
			swap(end,start,input);
		}
		swap(end,initStart,input);
		return end;
	}
	private static void swap(int left, int right, int[] array) {
		
		int tmp=array[right];
		array[right]=array[left];
		array[left]=tmp;
	}

}
