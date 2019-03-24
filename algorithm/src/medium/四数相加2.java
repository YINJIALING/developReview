package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 四数相加2 {

	public static void main(String[] args) {
//		System.out.println(fourSumCount(new int[] {1,2},new int[] {-1,-2},new int[] {-1,2},new int[] {0,2}));
		System.out.println(fourSumCount(new int[] {-1,-1},new int[] {-1,1},new int[] {-1,1},new int[] {1,-1}));
	}

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count=0;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				for(int k=0;k<C.length;k++) {
					for(int z=0;z<D.length;z++) {
						if(A[i]+B[j]+C[k]+D[z]==0)
							count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * 这样做的好处是：时间复杂度变成O(n^2)
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer,Integer> mapAB=new HashMap<>();//key:a,b相加之和;value:他们的和出现的次数
		int res=0;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				int key=A[i]+B[j];
				mapAB.put(key, mapAB.getOrDefault(key, 0)+1);
			}
		}
		
		for(int i=0;i<C.length;i++) {
			for(int j=0;j<D.length;j++) {
				int key=C[i]+D[j];
				if(mapAB.containsKey(0-key))//要另a+b+c+d=0，使a+b=0-(c+d)
					res+=mapAB.get(0-key);//res是满足if条件的mapAB.get(0-key)次数的累加
			}
		}
		return res;
	}

}
