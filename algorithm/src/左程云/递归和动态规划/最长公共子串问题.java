package 左程云.递归和动态规划;

public class 最长公共子串问题 {

	public static void main(String[] args) {
		char[] str1="1AB2345CD".toCharArray();
		char[] str2="12345EF".toCharArray();
		int[][] dp=getdp(str1,str2);
		String res=generate(str1,str2,dp);
		System.out.println(res);
	}

	private static String generate(char[] str1, char[] str2, int[][] dp) {
		int end=0,max=0;//寻找dp的max,就是最长公共子串的长度与结束的坐标
		for(int i=0;i<str1.length;i++) {
			for(int j=0;j<str2.length;++j) {
				if(dp[i][j]>max) {
					max=dp[i][j];
					end=i;
				}
			}
		}
		char[] res=new char[max];
		for(int i=max-1;i>=0;i--) {
			res[i]=str1[end--];
		}
		return String.valueOf(res);
	}

	/*
	 * dp[i][j]:str1第i个字符结束，str2第j个字符结束最长公共子串
	 */
	private static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp=new int[str1.length][str2.length];
		dp[0][0]=str1[0]==str2[0]?1:0;
		for(int i=1;i<str1.length;i++) {
			dp[i][0]=str1[i]==str2[0]?1:0;
		}
		for(int i=1;i<str2.length;i++) {
			dp[0][i]=str1[i]==str2[0]?1:0;
		}
		for(int i=1;i<str1.length;++i) {
			for(int j=1;j<str2.length;++j) {
				if(str1[i]==str2[j])
					dp[i][j]=dp[i-1][j-1]+1;
				
			}
		}
		return dp;
	}

}
