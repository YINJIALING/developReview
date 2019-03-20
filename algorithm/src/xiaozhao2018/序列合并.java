package xiaozhao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 序列合并 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int k=in.nextInt();
		int count=0;
		List<List<Integer>> list=new ArrayList<>();
		while(count<k) {
			int tmpCount=0;
			List<Integer> tmp=new ArrayList<>(8);
			while(tmpCount<8) {
				tmp.add(in.nextInt());
				tmpCount++;
			}
			list.add(tmp);
			count++;
		}
		int n=in.nextInt();
		System.out.println(test(list,n,k));
	}

	/**
	 * 将前n*k个的计算结果整理成list，并排序。结果直接返回结果集的n-1个数字
	 * @param list
	 * @param n
	 * @param k
	 * @return
	 */
	private static long test(List<List<Integer>> list, int n,int k) {
		List<Long> res=new ArrayList<>(n*k);
		int i=1;
		while(i<=n*k) {
			for(List<Integer> tmp:list) {
				long sum=cal(tmp,i);
				res.add(sum);
			}
			i++;
		}
		Collections.sort(res);
		
		return res.get(n-1);
	}

	private static long cal(List<Integer> tmp, int i) {
		return (long) (Math.pow(i, 7)*tmp.get(0)+Math.pow(i, 6)*tmp.get(1)+
				Math.pow(i, 5)*tmp.get(2)+Math.pow(i, 4)*tmp.get(3)+Math.pow(i, 3)*tmp.get(4)
				+Math.pow(i, 2)*tmp.get(5)+i*tmp.get(6)+tmp.get(7));
	}
	

}
