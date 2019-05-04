package 剑指offer2;

public class 数组中数字出现的次数 {

	public static void main(String[] args) {
		FindNumsAppearOnce(new int[] {2,4,3,6,3,2,5,5},8);

	}

	/**
	 * 将原数组拆分成2个子数组，每个子数组中都有一个出现1次的数，分别求异或，得到结果
	 * 1.将原数组依次异或resultExclusiveOR，得到一个值(2个出现1次的数异或的结果)，该值至少有1个1
	 * 2.根据resultExclusiveOR的第一个1出现的位置indexOf1，将数组拆分成两个数组
	 * 3.两个数组分别求异或
	 * @param data
	 * @param length
	 */
	private static void FindNumsAppearOnce(int[] data,int length) {
		if(data==null||length<2)
			return;
		int resultExclusiveOR=0;
		for(int i=0;i<length;++i)
			resultExclusiveOR^=data[i];
		
		int indexOf1=FindFirstBitIs1(resultExclusiveOR);
		int num1=0,num2=0;
		for(int i=0;i<length;i++) {
			if(isBit1(data[i],indexOf1))
				num1^=data[i];
			else
				num2^=data[i];
		}
		System.out.println(num1);
		System.out.println(num2);
	}

	/**
	 * 判断第indexOf1位是否是1
	 * @param i
	 * @param indexOf1
	 * @return
	 */
	private static boolean isBit1(int num, int indexOf1) {
		num=num>>indexOf1;
		return (num&1)==0;
	}

	/**
	 * 找到最右边是1的位
	 * @param resultExclusiveOR
	 * @return
	 */
	private static int FindFirstBitIs1(int num) {
		int indexBit=0;
		while((num&1)==0&&indexBit<8) {
			num=num>>1;
			indexBit++;
		}
		return indexBit;
	}
	

}
