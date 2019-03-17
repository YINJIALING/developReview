package easy;

public class 验证回文串 {

	public static void main(String[] args) {
//		boolean res=isPalindrome("A man, a plan, a canal: Panama");
//		System.out.println(res);
		System.out.println(isPalindrome(".,"));
	}

	/**
	 * 1.两个指针i,j,i从0开始，j从最后开始。
	 * 2.两个有效的数字比较，如果相等则继续比较，不相等则返回false
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		s=s.toLowerCase().trim();//全变为小写，并去空格
		if(s.length()==0||s.length()==1)return true;
		char[] c=s.toCharArray();
		int i=0,j=s.length()-1;
		while(i<=j) {
			while(!isValid(c[i])&&i<j)
				i++;
			while(!isValid(c[j])&&i<j)
				j--;
			if(c[i]!=c[j]) {
				return false;
			}else {
				i++;j--;
			}
		}
		return true;
	}

	//是否是数字或字符，如果是返回true，不是返回false
	private static boolean isValid(char c) {
		if((c<='9'&&c>='0')||(c>='a'&&c<='z'))return true;
		return false;
	}

}
