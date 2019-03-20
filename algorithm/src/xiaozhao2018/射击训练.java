package xiaozhao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 1.排序
 * 2.根据公式计算
 * @author yinjialing
 *
 */
public class 射击训练 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int i=0;
		List<Integer> list=new ArrayList<>(n);
		while(i<n) {
			list.add(in.nextInt());
			i++;
		}
		System.out.println(test(list,n));
	}

	private static int test(List<Integer> list, int n) {
		Collections.sort(list);
		int count=0;
	
		if(n>=4) {
			for(int a=0;a<n-3;a++) {
				for(int b=a+1;b<n-2;b++) {
					for(int c=b+1;c<n-1;c++) {
						for(int d=c+1;d<n;d++) {
							if(list.get(a)*list.get(b)*list.get(c)==list.get(d))
								count++;
							else if(list.get(a)*list.get(b)*list.get(c)<list.get(d)){
								break;
							}
							else {
								d=n;
							}
						}
					}
				}
			}
		}
		
		return count;
	}

}
