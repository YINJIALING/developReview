package xiaozhao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 排序 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count=0;
		List<Integer> list=new ArrayList<>();
		
		while(count<n) {
			list.add(sc.nextInt());
			count++;
		}
		System.out.println(test(list,n));
	}

	private static int test(List<Integer> list, int n) {
		List<Integer> tmp=new ArrayList<>(list.subList(0, list.size()));
		Collections.sort(tmp);
		int count=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)!=tmp.get(i))
				count++;
		}
		return count;
	}

}
