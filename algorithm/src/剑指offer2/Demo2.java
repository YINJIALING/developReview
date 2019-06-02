package 剑指offer2;

import java.util.ArrayList;

public class Demo2 {

	public static void main(String[] args) {
		gift(4, 3, 0, 0);
	}

	static ArrayList<Integer> tmp = new ArrayList<>();

	private static void gift(int n, int k, int curn, int curk) {
//		if (curn == n) {
//			while (tmp.size() != k) {
//				tmp.add(0);
//				curk++;
//			}
//
//		}
		if (curn >= n || curk >= k) {
			if (curk == k)
				print(tmp);
			tmp.clear();
			return;
			
		}
		for (int j=curk;j<=k;j++) {
			for (int i = n - curn; i >=0 && n - curn >= 0; i--) {
				tmp.add(i);
				gift(n, k, curn+i ,j+1);
			}
		}
//		for (int i = n - curn; i >=0 && n - curn >= 0; i--) {
//			for (int j=k-curk;j>=0&&k-curk>=0;j--) {
//				tmp.add(i);
//				curn =curn + i;
//				curk=curk+1;
//				gift(n, k, curn+i ,curk+1);
//			}
//			
//		}

	}

	private static void print(ArrayList<Integer> tmp2) {
		for (Integer index : tmp2)
			System.out.print(index + "|");
		System.out.println();
	}

}
