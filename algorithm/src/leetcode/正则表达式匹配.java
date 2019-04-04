package leetcode;

public class 正则表达式匹配 {

	public static void main(String[] args) {
//		System.out.println(isMatch("aa","a"));
//		System.out.println(isMatch("aa",".*"));
//		System.out.println(isMatch("aab","c*a*b"));
		System.out.println(isMatch("ippi","p*."));
	}

	public static boolean isMatch(String s, String p) {
		int m=s.length(),n=p.length();
		if(m==0&&n==0)return true;
		int pix=0;
		if(m==0) {
			while(pix<n) {
				if(p.charAt(pix)=='*')pix++;
				else break;
			}
			if(pix==n-1)return true;
			else return false;
		}
		if(n==0)return false;
	
		boolean[][] dp=new boolean[m][n];
		dp[0][0]=true;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				char p_char=p.charAt(j);
				if(i==0&&j!=0)
					dp[0][j]=(p_char=='*');
				else if(i>=1&&j>=1){
					char s_char=s.charAt(i);
					if(p_char=='*') {
						dp[i][j]=(j>=2&&dp[i][j-2])||(dp[i][j-1]&&p.charAt(j-1)==s_char)||dp[i-1][j];
					}else {

					dp[i][j]=(dp[i-1][j-1]&&(s_char==p_char||p_char=='.'));
					}
					
				}
			}
		}
		return dp[m-1][n-1];
	}

}
