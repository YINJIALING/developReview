package 剑指offer2;

public class 不用加减乘除做加法 {

	public static void main(String[] args) {
		System.out.println(Add(5,17));

	}

	/**
	 * 1.不考虑进位，两个数相加就是异或的结果
	 * 2.考虑进位，只有在2个1相加才产生进位,看成是与
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int Add(int num1, int num2) {
		int sum=0,carry=0;
		while(num2!=0) {
			sum=num1^num2;
			carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
		}
		return num1;
	}

}
