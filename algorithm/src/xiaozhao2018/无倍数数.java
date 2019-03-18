package xiaozhao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * 通过率为0
 * @author YJL
 *
 */

public class 无倍数数 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] num=new int[n];
		for(int i=0;i<n;i++) {
			num[i]=in.nextInt();
		}
		List<Integer> res=test(num,n);
		if(!res.isEmpty()) {
			for(Integer index:res) {
				System.out.print(index+" ");
			}
		}
		
		System.out.println();
	}

	/**
	 * 1.先排序
	 */
	private static List<Integer> test(int[] num, int n) {
		if(n==1)return null;
		Arrays.sort(num);
		List<Integer> res=new ArrayList<>(n);
		boolean[] tmp=new boolean[n];//判断该位置上是否有可以整除的数
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(num[j]%num[i]==0)
					tmp[i]=true;
				else
					tmp[i]=false;
			}
		}
		for(int i=0;i<n;i++) {
			if(!tmp[i])
				res.add(num[i]);
		}
		return res;
	}

}
