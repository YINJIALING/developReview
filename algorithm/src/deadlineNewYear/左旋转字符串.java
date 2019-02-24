package deadlineNewYear;

public class 左旋转字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LeftRotateString("abcXYZdef",3));
	}
	
	public static String LeftRotateString(String str,int n) {
        if(str==null||str.length()==0)
        		return "";
        n=n%str.length();
        char[] array=str.toCharArray();
        char[] copy=array.clone();
        for(int i=0;i<array.length-n;i++) {
        		array[i]=copy[i+n];
        }
        for(int i=0;i<n;i++) {
        		array[i+array.length-n]=copy[i];
        }
        StringBuffer res=new StringBuffer();
        for(char c:array) {
        		res.append(c);
        }
        return res.toString();
    }

}
