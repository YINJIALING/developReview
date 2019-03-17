package medium;

public class 字符串转换整数 {

	public static void main(String[] args) {
		System.out.println(myAtoi(" -42"));
//		System.out.println(myAtoi("words and 987"));
	}

	public static int myAtoi(String str) {
		str=str.trim();
		int res=0;
		if(str.length()==0)return res;
		char[] c=str.toCharArray();
		int i=0;
		boolean flag=true;
		
		if(c[i]=='+') {
			if(c.length==1)return res;
			else i++;
		}
		
		if(c[i]=='-') {
			if(c.length==1)return res;
			else {
				i++;
				flag=false;
			}		
		}
		
		if(i==0&&!isValidNumber(c[i]))return res;
		StringBuffer numberStr=new StringBuffer();
		while(i<c.length) {
			if(isValidNumber(c[i])) {
				numberStr.append(c[i++]);
			}else
				break;
		}
		
		if(numberStr.length()==0)return res;
		try{
			res=Integer.parseInt(numberStr.toString());	
		}catch(Exception e) {
			if(flag)return Integer.MAX_VALUE;
			else return Integer.MIN_VALUE;
		}
		if(!flag)return 0-res;
		return res;
		
	}

	//param:c is a valid number
	private static boolean isValidNumber(char c) {
		if(c>='0'&&c<='9')return true;
		return false;
	}
	


}
