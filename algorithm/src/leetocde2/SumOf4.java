package leetocde2;

import java.util.HashMap;

public class SumOf4 {

	public static void main(String[] args) {
		System.out.println(fourSumCount(new int[] {1,2},new int[] {-2,-1},new int[] {-1,2},new int[] {0,2}));

	}

	/**
	 * 1.用一个map存sumAB,以及出现的次数
	 * 2.count就等于0-sumCD的出现次数的累加 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int i:A) {
			for(int j:B) {
				int sumAB=i+j;
				map.put(sumAB, map.getOrDefault(sumAB, 0)+1);
			}
		}
		
		for(int i:C) {
			for(int j:D) {
				int sumCD=i+j;
				count+=map.getOrDefault(0-sumCD,0);	
			}
		}
		return count;
	}

}
