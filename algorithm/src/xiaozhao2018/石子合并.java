package xiaozhao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 石子合并 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int count=0;
		List<Integer> list=new ArrayList<>(n);
		while(count<n) {
			list.add(in.nextInt());
			count++;
		}
		System.out.println(test(list));
	}

	/**
	 * 1.先排序
	 * 2.要想score最大，只要先让最大的数*第二最大的数，计入score
	 * 3.此时，石子堆少1，但最大堆的量变成前一步的最大的数+前一步的第二最大的数
	 * @param list
	 * @return
	 */
	private static int test(List<Integer> list) {
		int score=0,i=list.size()-1;
		if(list.isEmpty())
			return score;
		if(list.size()==2)
			return list.get(0)*list.get(1);
		Collections.sort(list);
		while(i!=0) {
			score+=list.get(i)*list.get(i-1);
			list.set(i-1, list.get(i)+list.get(i-1));
			i--;
		}
		return score;
	}

}
