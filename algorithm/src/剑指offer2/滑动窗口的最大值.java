package 剑指offer2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class 滑动窗口的最大值 {

	public static void main(String[] args) {
		ArrayList<Integer> res=maxInWindows(new int[] {2,3,4,2,6,2,5,1},3);
		for(Integer index:res)
			System.out.print(index+",");
	}
	/**
	 * 在存入一个数字的下标前，要判断队列是否有小于待录入的数字
	 * 是的话，这些数字不可能是最大值，依次从队列中删去
	 * 同时如果有滑出的数字在队列中，也需要从头部删去这些数字
	 * @param num
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> maxInWindows=new ArrayList<>();
		if(num.length>=size&&size>0) {
			//两端开口的队列，保存的是滑动窗口最大值的下标
			Deque<Integer> index=new LinkedList<>();
			for(int i=0;i<size;i++) {
				while(!index.isEmpty()&&num[i]>=num[index.getLast()]) {
					index.removeLast();
				}
				index.add(i);
			}
			for(int i=size;i<num.length;i++) {
				maxInWindows.add(num[index.getFirst()]);
				
				while(!index.isEmpty()&&num[i]>=num[index.getLast()]) {
					index.removeLast();
				}
				if(!index.isEmpty()&&index.getFirst()<=(i-size))
					index.removeFirst();
				index.add(i);
			}
			maxInWindows.add(num[index.getFirst()]);
		}
		return maxInWindows;
    }

}
