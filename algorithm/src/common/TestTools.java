package common;
import java.util.List;

public class TestTools {
	
	
	public TestTools() {
		super();
		// TODO Auto-generated constructor stub
	}

	//打印List<List<Integer>>链表
	public void print(List<List<Integer>> res) {
		for(List<Integer> list:res) {
			list.forEach(str->{
				  System.out.print(str+" ");
				 });
			System.out.println();
		}
	}
	
	//打印数组
	public void printArr(int[] num) {
		for(int index:num) {
			System.out.print(index+",");
		}
		System.out.println();
	}

}
