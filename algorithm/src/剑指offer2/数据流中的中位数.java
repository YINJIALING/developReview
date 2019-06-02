package 剑指offer2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 数据流中的中位数 {
	//最小堆
	Queue<Integer> min=null;
	//最大堆
	Queue<Integer> max=null;

	public 数据流中的中位数() {
		min=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		max=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
	}

	public static void main(String[] args) {
		数据流中的中位数 t=new 数据流中的中位数();
		t.Insert(5);
		System.out.println(t.GetMedian());
		t.Insert(2);t.Insert(3);t.Insert(4);
		System.out.println(t.GetMedian());
		t.Insert(1);
		System.out.println(t.GetMedian());
		t.Insert(6);
		System.out.println(t.GetMedian());
		t.Insert(7);
		System.out.println(t.GetMedian());
		t.Insert(0);
		System.out.println(t.GetMedian());
		t.Insert(8);
		System.out.println(t.GetMedian());
	}

	/*
	 * 先判断是否是偶数
	 * 若是偶数，增加到min
	 * 否则，增加到max中
	 * 
	 * 如果增加到min中，需要保证max的所有数据都比min中的小
	 * 先将num增加到max中，取出max最顶元素放入min中
	 * 
	 */
	public void Insert(Integer num) {
		//判断是否是偶数
		if(((min.size()+max.size())&1)==0) {
			if(max.size()>0&&max.peek()>num) {
				max.add(num);
				num=max.poll();
			}
			min.add(num);
		}else {
			if(min.size()>0&&min.peek()<num) {
				min.add(num);
				num=min.poll();
			}
			max.add(num);
		}
	}

	public Double GetMedian() {
		int size=min.size()+max.size();
		double median=0;

		if((size&1)==0) {
			median=((double)(max.peek()+min.peek()))/2;
			return median;
//			return median;
		}
		else
			return (double) min.peek();
	}

}
