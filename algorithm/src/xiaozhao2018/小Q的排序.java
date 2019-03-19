package xiaozhao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 小Q的排序 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		List<Integer> list=new ArrayList<>(n);
		
		while(list.size()!=n) {
			list.add(in.nextInt());
		}
		System.out.println(test(list,n));
	}

	private static int test(List<Integer> list, int n) {
		if(n==1)return 0;
		boolean flag=true;
		//判断是否本来就有序
		for(int left=0;left<list.size()-1;left++) {
			for(int right=left;right<list.size();right++) {
				if(list.get(right)<list.get(left))flag=false;
			}
		}
		if(flag)return 0;
		//subList是左闭右开
		//这里的tmp1，tmp2需要对其操作，且不能影响到原list
		//可以影响到原list用List<Integer> tmp1=list.subList(0, list.size()-1)就好
		List<Integer> tmp1=new ArrayList<Integer>(list.subList(0, list.size()-1));
		List<Integer> tmp2=new ArrayList<Integer>(list.subList(1, list.size()));
		
		Collections.sort(tmp1);
		Collections.sort(tmp2);
		if(list.get(list.size()-1)>tmp1.get(tmp1.size()-1)||list.get(0)<tmp2.get(0))return 1;
		if(list.get(list.size()-1)>tmp1.get(0))return 2;
		else return 3;
	}

}
