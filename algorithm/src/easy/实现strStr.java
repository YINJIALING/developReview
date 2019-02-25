package easy;

public class 实现strStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello","ll"));
		System.out.println(strStr("aaaaa","bba"));
	}
	 public static int strStr(String haystack, String needle) {
	      int res=-1;
	      if(needle==null)return 0;
//	      if()
	    	 return haystack.indexOf(needle, 0);
	      
	 }

}
