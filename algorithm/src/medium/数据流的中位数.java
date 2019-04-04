package medium;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 在数据流中，数据会不断涌入结构中，那么也就面临着需要多次动态调整以获得中位数。 因此实现的数据结构需要既需要快速找到中位数，也需要做到快速调整。

首先能想到就是二叉搜索树，在平衡状态下，树顶必定是中间数，然后再根据长度的奇偶性决定是否取两个数。

此方法效率高，但是手动编写较费时费力。

根据只需获得中间数的想法，可以将数据分为左右两边，一边以最大堆的形式实现，可以快速获得左侧最大数， 另一边则以最小堆的形式实现。其中需要注意的一点就是左右侧数据的长度差不能超过1。 这种实现方式的效率与AVL平衡二叉搜索树的效率相近，但编写更快
 * @author yinjialing
 *
 */
public class 数据流的中位数 {
	private int size;

	// 最小堆存放较大的一半元素
	private PriorityQueue<Integer> minPQ;

	// 最大堆存放较小的一半元素
	private PriorityQueue<Integer> maxPQ;


	public static void main(String[] args) {
		数据流的中位数 t=new 数据流的中位数();
		t.addNum(2);
		t.addNum(3);
		t.addNum(1);
		t.addNum(4);
//		t.addNum(5);
//		t.addNum(6);
		System.out.println("res:"+t.findMedian());
	}

	public 数据流的中位数() {

		size = 0;
		minPQ = new PriorityQueue<>();
		maxPQ = new PriorityQueue<>((a, b) -> b - a);
	}

	public void addNum(int num) {
		// 当最小堆中元素不满一半时对其插入
				if (minPQ.size() < ++size / 2) {
					if (num >= maxPQ.peek()) {
						minPQ.add(num);
					} else {
						minPQ.add(maxPQ.remove());
						maxPQ.add(num);
					}
				} else {
					if (maxPQ.isEmpty() || num <= minPQ.peek()) {
						maxPQ.add(num);
					} else {
						maxPQ.add(minPQ.remove());
						minPQ.add(num);
					}
				}
	}

	public double findMedian() {
		if (maxPQ.isEmpty() && minPQ.isEmpty()) {
			throw new IllegalArgumentException("No data");
		}
		
		if (maxPQ.size() > minPQ.size()) {
			return (double) maxPQ.peek();
		}

		return (double) (maxPQ.peek() + minPQ.peek()) / 2;
		
		 
	}

	// public static double findMedian(int[] nums) {
	// int n = nums.length;
	// Queue<Integer> heap = new PriorityQueue<>(n, new Comparator<Integer>() {
	//
	// @Override
	// public int compare(Integer o1, Integer o2) {
	// return o1.compareTo(o2);
	// }
	// });
	// for (int index : nums) {
	// heap.add(index);
	// }
	// Iterator<Integer> it = heap.iterator();
	// int count=0;
	// if (n % 2 != 0) {
	// while (it.hasNext()&&count!=n/2) {
	// count++;
	// it.next();
	// }
	// return it.next().intValue();
	// }else {
	// while (it.hasNext()&&count!=n/2) {
	// count++;
	// it.next();
	// }
	// }
	// return (it.next().intValue()+it.next().intValue())>>1;
	// }

}

