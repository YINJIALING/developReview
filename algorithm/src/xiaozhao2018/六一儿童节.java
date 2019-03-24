package xiaozhao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 六一儿童节 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		List<Integer> numsN=new ArrayList<>();
		List<Integer> numsM=new ArrayList<>();
		while(numsN.size()<n) {
			numsN.add(in.nextInt());
		}
		int m=in.nextInt();
		while(numsM.size()<m) {
			numsM.add(in.nextInt());
		}
		
		System.out.println(test(n,numsN,m,numsM));
	}

	/**
	 * 1.给数组numsN,numsM分别排序
	 * 2.设两个指针i,j。分别记录每个学生需要的巧克力是否大于等于每块巧克力
	 * @param n
	 * @param numsN
	 * @param m
	 * @param numsM
	 * @return
	 */
	private static int test(int n, List<Integer> numsN, int m, List<Integer> numsM) {
		int count=0;
		Collections.sort(numsN);
		Collections.sort(numsM);
		
		int i=0,j=0;
		while(i<numsN.size()&&j<numsM.size()) {
			if(numsN.get(i)<=numsM.get(j)) {
				count++;
				i++;j++;
			}else {
				j++;
			}
				
		}
		return count;
	}

}
