package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
        if(str==null||str.length()<=0){
            return;
        }
		String[] array = str.split(" ");
		if(array.length<2)
			return;
		try {
			int n=Integer.parseInt(array[0]);
			int m=Integer.parseInt(array[1]);
			test(n,m);
		} catch (NumberFormatException e) {
			return;
		}
	}

	/**
	 * @param n: n个人
	 * @param m: 报到m的人退出游戏
	 */
	public static void test(int n, int m) {
		if(n<1||m<1)
			System.out.println("-1"); 
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		int index=-1;
		while(list.size()>1) {
			index = (index+m)%(list.size());
			System.out.print(list.remove(index)+" ");
			index--;
		}
		System.out.println();
		System.out.println(list.get(0));	
	}

}
