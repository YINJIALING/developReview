package xiaozhao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 操作序列 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		List<Integer> list=new ArrayList<>();
		int i=0;
		while(i<n) {
			list.add(in.nextInt());
			i++;
		}
		System.out.println(test(list,n));
	}

	private static String test(List<Integer> list, int n) {
		if(n==1)return list.get(0).toString();
		StringBuffer str=new StringBuffer(" "+list.get(0)+" ");
		for(int i=1;i<list.size();i++) {
			str.append(list.get(i)+" ");
			str.reverse();
		}
		
		//去空格
		return str.substring(1, str.length()-1).toString();
	}

}
