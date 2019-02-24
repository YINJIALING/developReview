package deadlineNewYear;

public class 翻转单词顺序列 {

	public static void main(String[] args) {
		System.out.println(ReverseSentence(""));
	}

	public static String ReverseSentence(String str) {
		StringBuffer res=new StringBuffer();
		if(str==null||str.length()==0)
			return res.toString();
		if(str.length()==1)
			return str;
		try {
			String[] array=str.split(" ");
			if(str.length()>1) {
				for(int i=array.length;i>0;i--) {
					res.append(array[i-1]);
					res.append(" ");
				}
			}
			
			return res.substring(0, res.length()-1).toString();
		}catch(Exception e) {
			return str;
		}
		
	}
}
