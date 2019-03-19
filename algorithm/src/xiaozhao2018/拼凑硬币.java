package xiaozhao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 拼凑硬币 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(test1(n));
	}

	/**
	 * 这个是错的，只考虑了连续的选
	 * @param n
	 * @return
	 */
	private static int test1(int n) {
		List<Integer> num=initCoins(n);
		int count=0;
		for(int left=0;left<num.size();left++) {
			if(num.get(left)==n) {
				count++;break;
			}
			if(left<num.size()-1) {
				int sum=num.get(left);
				for(int right=left;right<num.size();right++) {
					sum+=num.get(right);
					if(sum==n) {
						count++;break;
					}else if(sum>n)
						break;
				}
			}
		}
		return count;
	}

	/**
	 * 初始化硬币
	 * @param n
	 * @return
	 */
	private static List<Integer> initCoins(int n) {
		List<Integer> list=new ArrayList<>();
		int i=1;
		while(i<=n) {
			list.add(i);
			list.add(i);
			i=i*2;
		}
		
		return list;
	}
	
	

}
