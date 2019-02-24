package leetcode;

public class 解码方法 {

	public static void main(String[] args) {
		String s1="27";
		String s2="226";
		System.out.println(numDecodings(s1));
		//System.out.println(numDecodings(s2));
	}
	public static int numDecodings(String s) {
		// 预处理输入的字符串，因为存在不是数字的情况或为0
        char[] cOrigin=s.toCharArray();
        String tmp=process(cOrigin);
        if(tmp==null||tmp.length()==0)return 0;
        char[] c=tmp.toCharArray();
       
        if(c.length==1) {
        		return 1;
        }
        
        int[] dp=new int[c.length];   
        	dp[0]=1;
        
        if(c[1]<='6'&&c[0]<='2')
        		dp[1]=2;
        else {
        		dp[1]=1;
        }
        for(int i=2;i<c.length;i++) {
        	dp[i]=(c[i]<='6'&&c[i-1]<='2')?(dp[i-2]+dp[i-1]):dp[i-1];
        }
        return dp[c.length-1];
    }
	
	private static String process(char[] cOrigin) {
		if(cOrigin==null||cOrigin.length==0)return null;
		StringBuffer str=new StringBuffer();
		for(int i=0;i<cOrigin.length;i++) {
			if(isNumber(cOrigin[i]))
				str.append(cOrigin[i]);
		}
		return str.toString();
	}
	private static boolean isNumber(char c) {
		if(c>='1'&&c<='9')
			return true;
		else
			return false;
	}
}
