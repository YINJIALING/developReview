package deadlineNewYear;

public class 把字符串转换成整数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StrToInt("+2147483647"));
		System.out.println(StrToInt("1a33"));
	}

	public static int StrToInt(String str) {
		if(str==null||str.length()==0)
			return 0;
		char[] array=str.toCharArray();
		int index=0;
		//处理正负号
		boolean isPostive=true;
		if(array[0]=='+') 
			index++;
		else if(array[0]=='-') {
			index++;
			isPostive=false;
		}		
		int sum=0,count=1;
		for(int i=array.length-1;i>=index;i--) {
			if(array[i]>'9'||array[i]<'0')
				return 0;
			sum+=count*(array[i]-'0');
			count*=10;
		}
		return isPostive==true?sum:(0-sum);	
	}

}
