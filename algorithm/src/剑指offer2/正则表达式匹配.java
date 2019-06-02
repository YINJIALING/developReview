package 剑指offer2;

public class 正则表达式匹配 {

	public static void main(String[] args) {
		System.out.println(macth("aaa","ab*c*.a"));

	}
	private static boolean macth(String str, String pattern) {
		if(str==null||pattern==null)
			return false;
	
		return macthCore(str,pattern,0,0);
	}
	
	private static boolean macthCore(String str, String pattern,int p1,int p2) {
		//str,pattern都到尾，匹配成功
		if(p1>=str.length()&&p2>=pattern.length())
			return true;
		
		//pattern先到尾，匹配 失败
		if(p1<str.length()&&p2>=pattern.length())
			return false;
		
		//pattern的后一位是*，且第p2与p1匹配，分三种情况
		//1.匹配一个字符，p1后移1位，p2后移2位
		//2.匹配0个，p1不变，p2后移2位
		//3.匹配一个，p1后移1位，p2不变，还能继续匹配
		if(p2+1<pattern.length()&&pattern.charAt(p2+1)=='*') {
			if(p1<str.length()&&(pattern.charAt(p2)==str.charAt(p1)||pattern.charAt(p2)=='.')) {
				return macthCore(str,pattern,p1+1,p2+2)||macthCore(str,pattern,p1,p2+2)||macthCore(str,pattern,p1+1,p2);
			}else {
				return macthCore(str,pattern,p1,p2+2);
			}
		}
		
		//pattern的后一位不是*，分2种情况,当前是.或者=
		if(p1<str.length()&&((p2<pattern.length()&&pattern.charAt(p2)=='.')||pattern.charAt(p2)==str.charAt(p1)))
			return macthCore(str,pattern,p1+1,p2+1);

		//上面的都匹配失败，就直接返回false
		return false;
	}
	

}
