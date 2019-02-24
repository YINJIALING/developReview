package deadlineNewYear;

public class 整数中1出现的次数从1到n整数中1出现的次数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf1Between1AndN_Solution(55));
	}
	public static int NumberOf1Between1AndN_Solution(int n) {
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
	 * 包含1的次数
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
