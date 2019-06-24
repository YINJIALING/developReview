package 剑指offer2;

public class 把数字翻译成字符串 {

	public static void main(String[] args) {
		System.out.println(GetTranslationCount(12258));

	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	private static int GetTranslationCount(int number) {
		if(number<0)
			return -1;
		String numberInString=number+"";
		return GetTranslationCount(numberInString);
	}

	/**
	 * 从后开始，从后到前计算不同的数目
	 * 用一个数组count来存
	 * @param number
	 * @return
	 */
	private static int GetTranslationCount(String number) {
		int length=number.length();
		int[] counts=new int[length];
		int count=0;
		for(int i=length-1;i>=0;i--) {
			count=0;
			if(i<length-1)
				count=counts[i+1];
			else
				count=1;
			if(i<length-1) {
				int digit1=number.charAt(i)-'0';
				int digit2=number.charAt(i+1)-'0';
				int converted=10*digit1+digit2;
				if(converted>=10&&converted<=25) {
					if(i<length-2)
						count+=counts[i+2];
					else
						count+=1;
				}

			}
			counts[i]=count;
		}
		return counts[0];
	}
	

}
