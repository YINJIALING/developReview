package 左程云.递归和动态规划;

public class 字符串的交错组成 {

	public static void main(String[] args) {
		System.out.println(isCross("AB","12","AB12"));
		System.out.println(isCross("AB","12","ab12"));

	}

	/**
	 * 1.如果aim是str1和str2的交错组成，那么aim的长度一定是m+n, 否则返回false
	 * 2.dp[i][j]:aim[0~i+j-1]能否被str1[0~i-1]和str2[0~j-1]交错组成
	 * 初始化：dp[0][0]=true当aim 为空串的时候可以被空串str1,空串str2组成
	 * dp[i][0]表示aim[0~i-1]能否被str1[0~i-1]组成.当aim[0~i-1]=str1[0~i-1],返回true，否则false
	 * dp[0][i]表示aim[0~i-1]能否被str2[0~i-1]组成
	 * 其他情况
	 * dp[i-1][j]为true&&str1[i-1]==aim[i+j-1]，那么dp[i][j]=dp[i-1][j]=true
	 * dp[i][j-1]为true&&str2[j-1]==aim[i+j-1]，那么dp[i][j]=dp[i-1][j]=true
	 * 其他情况为false
	 * @param str1
	 * @param str2
	 * @param aim
	 * @return
	 */
	private static boolean isCross(String str1, String str2, String aim) {
		int m=str1.length(),n=str2.length();
		if(aim.length()!=m+n)return false;
		boolean[][] dp=new boolean[m+1][n+1];
		char[] ch1=str1.toCharArray();
		char[] ch2=str2.toCharArray();
		char[] chaim=aim.toCharArray();
		dp[0][0]=true;
		for(int i=1;i<=m;++i) {
			if(chaim[i-1]!=ch1[i-1])break;
			dp[i][0]=true;
		}
		for(int i=1;i<=n;++i) {
			if(chaim[i-1]!=ch2[i-1])break;
			dp[0][i]=true;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if((dp[i-1][j]&&ch1[i-1]==chaim[i+j-1])||(dp[i][j-1]&&ch2[j-1]==chaim[i+j-1]))
					dp[i][j]=true;
				else
					dp[i][j]=false;
			}
			
		}
		return dp[m][n];
	}
	

}
