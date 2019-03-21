package xiaozhao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 备忘录算法
 * @author yinjialing
 *
 */

public class 水仙花数 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			print(test(sc.nextInt(),sc.nextInt()));
		}
	
		
	}

	private static void print(List<Integer> test) {
		if(test.isEmpty())
			System.out.println("no");
		else {
			for(Integer index:test) {
				System.out.print(index+" ");
			}
			System.out.println();
		}
		
	}

	private static List<Integer> test(Integer m, Integer n) {
		
		List<Integer> res=new ArrayList<>();
		for(int i=m;i<n;i++) {
			if(check(i))
				res.add(i);
		}
		
		return res;
	}

	private static boolean check(int i) {
		int j=i;
		int count=0;
		while(j!=0) {
			count+=Math.pow(j%10, 3);
			j=j/10;
		}
		if(count==i)
			return true;
		return false;
	}

}
