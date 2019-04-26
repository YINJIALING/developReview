package xiaozhao2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * 就是求1-n，有限域的个数
 * 也就是求1-n，存在多个数可表示为某个素数的方幂
 * 结果=素数的个数(k=1)+素数幂的个数
 * @author yinjialing
 *
 */
public class 有限域 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(limitedSpace(n));
	}

	private static int limitedSpace(int n) {
		if(n<2) return 0;
		Set<Integer> set=new HashSet<>();
		Set<Integer> set2=new HashSet<>();
		for(int i=2;i<=n;i++) {
			if(isPrime(i))
				set.add(i);
		}
		//注意遍历set时，如果对set进行会报错
		for(Integer index:set) {
			int tmp=index;
			while(tmp<n) {
				tmp=index*tmp;
				if(tmp<n)
					set2.add(tmp);
			}
		}
		return set.size()+set2.size();
	}

	//是否是素数
	private static boolean isPrime(int i) {
		if(i<2)return false;
		for(int j=2;j<i;j++) {
			if(i%j==0)return false;
		}
		return true;
	}

}
