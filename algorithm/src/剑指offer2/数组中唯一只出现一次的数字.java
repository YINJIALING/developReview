package 剑指offer2;

public class 数组中唯一只出现一次的数字 {

	public static void main(String[] args) {
		System.out.println(findNumberOnce(new int[] {2,3,1,3,2,3,2}));
	}

	/**
	 * 1.先计算二进制每一位的和，用一个长度为32的数组来累加
	 * 2.如果该位上的和不能被3整除，说明他是一个出现一次的一部分
	 * @param is
	 * @return
	 */
	private static int findNumberOnce(int[] numbers) {
		int length=numbers.length;
		if(numbers==null||length==0)
			return -1;
		// 存储二进制表示的每一位的和
		int[] bitSum=new int[32];
		for(int i=0;i<length;i++) {
			int bitMask=1;
			for(int j=31;j>=0;--j) {
				int bit=numbers[i]&bitMask;
				if(bit!=0)
					bitSum[j]+=1;
				bitMask=bitMask<<1;
				
			}
		}
		int result=0;
		for(int i=0;i<32;i++) {
			result=result<<1;
			result+=bitSum[i]%3;
		}
		return result;
	}

}
