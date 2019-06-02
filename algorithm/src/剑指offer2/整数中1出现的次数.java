package 剑指offer2;

public class 整数中1出现的次数 {

	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(100));
	System.out.println(NumberOf1Between1AndN_Solution2(100));
	}
	public static int NumberOf1Between1AndN_Solution(int n) {
		if(n<=0)return 0;
		return NumberOf1Between1AndN_Solution(n+"");
		
    }
	/*
	 *  1.先计算最大位为1的个数
	 *  2.再计算除了最大位，其他位出现1的个数
	 *  3.计算去除最大位，其他位组成一个新字符串出现1的数目
	 *  4.将1-3的结果相加
	 */
	private static int NumberOf1Between1AndN_Solution(String strN ) {
		if(strN==null||strN.charAt(0)<'0'||strN.charAt(0)>'9'||strN.length()==0)
			return 0;
		
		int first=strN.charAt(0)-'0';
		int length=strN.length();
		//最大位上的数是0，且只有1位
		if(length==1&&first==0)
			return 0;
		//最大位上的数不是0，且只有1位
		if(length==1&&first>0)
			return 1;
		
		int numFirstDigit=0;
		//最大位上的数不是1，设strN=21345
		if(first>1)
			numFirstDigit=powerBase10(length-1);
		else if(first==1)//最大位上的数是1，如：计算1000-1234中第一位出现1的个数,注意+1
			numFirstDigit=Integer.parseInt(strN)-powerBase10(length-1)+1;
		
		//计算除了最大位为1外，其他位出现1的次数
		int numOtherDigit=first*(length-1)*powerBase10(length-2);
		
		//计算1-1345中1的个数
		int numRecursive=NumberOf1Between1AndN_Solution(strN.substring(1));
		return numFirstDigit+numRecursive+numOtherDigit;
	}
	private static int powerBase10(int n) {
		int result=1;
		for(int i=0;i<n;i++) {
			result*=10;
		}
		return result;
	}
	
	public static int NumberOf1Between1AndN_Solution2(int n) {
	    if(n<1)
			   return 0;
		   int count=0;
		   if(n==1)
			   return 1;
		   for(int i=1;i<=n;i++) {
			   //if(isContainsOne(i)!=0)
				   count+=isContainsOne(i);
		   }
		   return count;
	    }
	    /**
		 * 是否包含1
		 * @param n
		 * @return
		 */
		private static int isContainsOne(int n) {
			int count=0;
			char[] array=(n+"").toCharArray();
			for(char c:array) {
				if(c=='1')
					count++;
			}
			return count;
		}

}
