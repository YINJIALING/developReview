package deadlineNewYear;

import java.util.HashMap;
import java.util.Map;

public class 数组中重复的数字 {

	public static void main(String[] args) {
		int[] arr= {2,3,1,0,2,5,3};
//		System.out.println(process1(arr));
		System.out.println(process2(arr));
	}

	// 重排数组，交换下标
	private static int process2(int[] arr) {
		if(arr==null||arr.length==0||arr.length==1)
			return -1;
		for(int i=0;i<arr.length;i++) {
			if(i!=arr[i]) {
				int temp=arr[i];
				arr[i]=arr[arr[i]];
				arr[temp]=temp;
			}
			print(arr);
			if(i!=arr[i]&&arr[arr[i]]==arr[i])
				return arr[i];
		}
		return -1;
	}

	// 哈希表
	private static int process1(int[] arr) {
		if(arr==null||arr.length==0||arr.length==1)
			return -1;
//		int map[]=new int[arr.length];
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else {
				return arr[i];
			}
		}
		return -1;
	}
	
	private static void print(int[] arr) {
		for(int index:arr) {
			System.out.print(index+"\t");
		}
		System.out.println();
	}

}
