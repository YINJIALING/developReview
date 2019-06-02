package 剑指offer2;

public class 数字序列中的某一位的数字 {

	public static void main(String[] args) {
		System.out.println(digitAtIndex(1001));
	}

	/**
	 * 1。
	 * @param index
	 * @return
	 */
	private static int digitAtIndex(int index) {
		if(index<0)return -1;
		int digits=1;
		while(true) {
			int numbers=countOfNumbers(digits);
			if(index<numbers*digits) {
				return digitsAtIndex(index,digits);
			}
			index-=digits*numbers;
			digits++;
		}
	}

	/**
	 * 计算在第digits位数构成的数字序列中第index返回的是几
	 * @param index
	 * @param digits
	 * @return
	 */
	private static int digitsAtIndex(int index, int digits) {
		int number=beginNumber(digits)+index/digits;
		int indexFromRight=digits-index%digits;
		for(int i=1;i<indexFromRight;i++) {
			number/=10;
		}
		return number%10;
	}

	/**
	 * 开始的数字
	 * @param digits
	 * @return
	 */
	private static int beginNumber(int digits) {
		return (int) Math.pow(10, digits-1);
	}

	/**
	 * 计算digits位数字有多少个
	 * @param digits
	 * @return
	 */
	private static int countOfNumbers(int digits) {
		if(digits==1)
			return 10;
		return (int) (Math.pow(10, digits-1)*9);
	}

}
