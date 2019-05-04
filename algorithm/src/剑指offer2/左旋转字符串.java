package 剑指offer2;

public class 左旋转字符串 {

	public static void main(String[] args) {
		System.out.println(LeftRotateString("abcdefg",2));

	}

	/**
	 * 1.先翻转前半部分
	 * 2.翻转后半部分
	 * 3.翻转整个str
	 * @param str
	 * @param n
	 * @return
	 */
	public static String LeftRotateString(String str, int n) {
		if(str==null||str.length()==0||n<1||n>str.length())return str;
		int length=str.length();
		StringBuffer sbf=new StringBuffer(str);
		reserve(0,n-1,sbf);
		reserve(n,length-1,sbf);
		
		reserve(0,length-1,sbf);
		return sbf.toString();
	}

	private static void reserve(int pBegin, int pEnd, StringBuffer str) {
		while(pBegin<pEnd) {
			char tmp=str.charAt(pBegin);
			str.setCharAt(pBegin, str.charAt(pEnd));
			str.setCharAt(pEnd, tmp);
			pBegin++;pEnd--;
		}
		
	}

}
