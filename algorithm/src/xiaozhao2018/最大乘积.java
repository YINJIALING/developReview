package xiaozhao2018;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 最大乘积 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		List<Long> list=new ArrayList<>();
		int n=in.nextInt();
		int i=0;
		while(i<n) {
			//注意这里输入类型也需要是long
			list.add(in.nextLong());i++;
		}
		System.out.println(test(list));
	}

	/**
	 * 1.先排序
	 * 2.统计正数负数和0出现的次数
	 * 3.根据正数负数和0出现的次数，进行计算最大值
	 * @param list
	 * @return
	 */
	private static long test(List<Long> list) {
		Collections.sort(list);
		int right=list.size();
		long leftChengji=list.get(0)*list.get(1)*list.get(2);
		long rightChengji=list.get(right-1)*list.get(right-2)*list.get(right-3);
		if(right==3)return leftChengji;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(Long index:list) {
			if(index==0)
				map.put(0, 1+map.getOrDefault(0, 0));
			else if(index>0) {
				map.put(1, 1+map.getOrDefault(1, 0));
			}else {
				map.put(-1, 1+map.getOrDefault(-1, 0));
			}
		}
		//只有正数
		if(!map.containsKey(0)&&!map.containsKey(-1)) {
			return rightChengji;
		}
		
		//只有负数
		if(!map.containsKey(0)&&!map.containsKey(1)) {
			return leftChengji;
		}
		
		//有正有负
		if((map.containsKey(1)&&map.get(1)>=3)||(map.containsKey(-1)&&map.get(-1)>=3))
			return Math.max(list.get(0)*list.get(1)*list.get(right-1), rightChengji);
		if(map.containsKey(0))return 0;
		else
			return Math.max(list.get(0)*list.get(1)*list.get(right-1), rightChengji);
	}
	
	

}
