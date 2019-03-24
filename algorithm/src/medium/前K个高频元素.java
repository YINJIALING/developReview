package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 思路同有序矩阵中的第k个元素
 * topk问题优先考虑使用优先队列
 * @author yinjialing
 *
 */
public class 前K个高频元素 {

	public static void main(String[] args) {
		List<Integer> res=topKFrequent(new int[] {1,1,1,2,2,3},2);
		for(Integer index:res) {
			System.out.print(index+" ");
		}
	}

	/**
	 * 1.使用 map记录每个元素记录的次数
	 * 2.遍历map,将map中的元素按照其出现的次数放在heap中，出现次数小的放在堆顶，(以便推出)
	 * 3.将heap中的元素放入res
	 * @param nums
	 * @param k
	 * @return
	 */
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		
		Queue<Integer> heap=new PriorityQueue<>(k,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o1).compareTo(map.get(o2));//最小的放在顶上，最小优先队列
			}

		});
			
		List<Integer> res=new ArrayList<>();
		for(Integer key:map.keySet()) {
			if(heap.size()<k) {
				heap.add(key);
			}else {
				if(map.get(heap.peek())<map.get(key)) {
					heap.poll();
					heap.add(key);
				}					
			}
		}
		
		while(res.size()<k) {
			res.add(heap.poll());
		}
	
		return res;
		
	}

}
