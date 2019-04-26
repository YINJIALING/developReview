package leetcode;

public class 只出现一次的数字 {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {2,1,2}));
	}

	/**
	 * 异或，相同为0，不同为1
	 * 思路：对所有元素求异或，得到的结果即为只出现一次的元素
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {	
		int res=0;
		for(int index:nums) {
			res=res^index;// 异或运算
		}
		return res;
	}

}
