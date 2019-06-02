package 剑指offer2;

public class 表示数值的字符串 {

	public static void main(String[] args) {
		boolean flag=isNumeric(new char[] {'+','5','0','0'});
		System.out.println(flag);
//		表示数值的字符串 t=new 表示数值的字符串();
//		
//		//123.45e+6
//		System.out.println(t.isNumeric(new char[] {'+','5','0','0'}));
	}
	static int index=0;
	public static boolean isNumeric(char[] str) {	
		if(str==null)return false;
		boolean numeric=scanInteger(str);
		if(index<str.length&&str[index]=='.') {
			index++;
			//1.小数可以没整数部分 2.没小数部分 3.小数点前面后面都有数字
			numeric=scanUnsignedInteger(str)||numeric;
		}
		//指数部分
		if(index<str.length&&(str[index]=='e'||str[index]=='E')) {
			index++;
			//1.e前面没数字不能表示数字，如e1,e2
			//2.e后面没整数不能表示数字，如12e,12e+5.4
			numeric=numeric&&scanInteger(str);
		}
		return numeric&&index==str.length;
	}

	//匹配正负号
	private static boolean scanInteger(char[] str) {
		if(index<str.length&&(str[index]=='+'||str[index]=='-'))
			index++;
		return scanUnsignedInteger(str);
	}

	//匹配0-9的数位，类似于一个符号的数
	private static boolean scanUnsignedInteger(char[] str) {
		int tmp=index;
		while(index<str.length&&str[index]>='0'&&str[index]<='9')
			index++;
		//当str存在若干个0-9的数字，返回true
		return (index>tmp);
	}

}
