package 剑指offer2;

import java.util.Deque;
import java.util.LinkedList;

public class 队列的最大值 {
	Deque<InternalData> data=null;
	Deque<InternalData> maximums=null;
	int currentIndex;
	

	public 队列的最大值() {
		data=new LinkedList<>();
		maximums = new LinkedList<>();
		currentIndex = 0;
	}
	
	private void push(int number) {
		while(!maximums.isEmpty()&&number>=maximums.getLast().number)
			maximums.removeLast();
		InternalData internalData=new InternalData(number,currentIndex);
		currentIndex++;
		maximums.add(internalData);
		data.add(internalData);
	}
	
	private void pop() {
		if(maximums.getFirst().number==data.remove().number)
			maximums.removeFirst();
	}

	private int getMax() {
		return maximums.getFirst().number;
	}
	public static void main(String[] args) {
		
		队列的最大值 t=new 队列的最大值 ();
		t.push(2);
		t.push(3);
		t.push(4);
		t.push(6);
		t.push(2);
		System.out.println(t.getMax());
		t.pop();
		System.out.println(t.getMax());
		t.pop();
		System.out.println(t.getMax());
		t.pop();
		System.out.println(t.getMax());
		t.pop();
		System.out.println(t.getMax());
		t.pop();
		
	}
	

}
class InternalData{
	int number;
	int index;
	
	public InternalData(int number, int index) {
		super();
		this.number = number;
		this.index = index;
	}
	
}
