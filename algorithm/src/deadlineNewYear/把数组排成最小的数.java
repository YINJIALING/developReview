package deadlineNewYear;

import java.util.ArrayList;
import java.util.List;

public class 把数组排成最小的数 {

	public static void main(String[] args) {
		int nums[]= {3,32,321};
		System.out.println(PrintMinNumber(nums));
	}
	public static String PrintMinNumber(int [] numbers) {
		//先求数组的全排列
		List<List<Integer>> list=new ArrayList<>();
		list=orderAll(numbers,0,numbers.length,list);
		//取数组拼接和
		List<String> sumList=getStrByArray(list);
		//取最小值
		String res=getStrByStr(sumList);
		return res;
    }
	/**
	 * 根据传入的字符串集合获取最小值
	 * @param sumList
	 * @return
	 */
	private static String getStrByStr(List<String> sumList) {
		long min=Long.parseLong(sumList.get(0));
		for(String str:sumList) {
			if(min>Long.parseLong(str))
				min=Long.parseLong(str);
		}
		return min+"";
	}
	private static List<String> getStrByArray(List<List<Integer>> list) {
		List<String> resStr=new ArrayList<>();
		for(List<Integer> temp:list) {
			StringBuffer str=new StringBuffer();
			for(Integer i:temp) {
				str.append(i);
			}
			resStr.add(str.toString());
		}
		return resStr;
	}
	/**
	 * 求数组的全排列
	 * @param numbers
	 * @param start
	 * @param end
	 * return list<array>
	 */
	private static ArrayList<List<Integer>> orderAll(int[] numbers,int start,int end,List<List<Integer>> list){
		if(start>=end) {
			List<Integer> tempList=new ArrayList<>();
			for(int i=0;i<end;i++) {
				tempList.add(numbers[i]);
			}
			list.add(tempList);
		}
		for(int i=start;i<end;i++) {
			int temp=numbers[i];
			numbers[i]=numbers[start];
			numbers[start]=temp;//交换i,k的位置
			orderAll(numbers,start+1,end,list);
			temp=numbers[i];
			numbers[i]=numbers[start];
			numbers[start]=temp;//再次交换i,k的位置
		}
		return (ArrayList<List<Integer>>) list;
	}

}
