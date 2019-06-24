package 左程云.递归和动态规划;

public class 最长公共子序列 {

	public static void main(String[] args) {
		char[] str1="1A2C3D4B56".toCharArray();
		char[] str2="B1DD23CA45B6A".toCharArray();
		int[][] dp=getdp(str1,str2);
		String substr=lcse(str1,str2,dp); 
		System.out.println(substr);
	}

	//根据dp还原序列
	private static String lcse(char[] str1, char[] str2, int[][] dp) {
		char[] res=new char[dp[str1.length-1][str2.length-1]];
		int index=res.length-1;//res的索引
		int m=str1.length-1;
		int n=str2.length-1;
		while(index>=0) {
			if(n>0&&dp[m][n]==dp[m][n-1])//说明str2[n]不在序列中
				n--;
			else if(m>0&&dp[m][n]==dp[m-1][n])
				m--;
			else {//说明找到了一个公共字符
				res[index--]=str1[m];
				m--;n--;
			}
				
		}
		return String.valueOf(res);
	}

	/*
	 * DP[i][j]:str1第i个字符结束，str2第j个字符结束最长公共子序列数
	 */
	private static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp=new int[str1.length][str2.length];
		dp[0][0]=str1[0]==str2[0]?1:0;//str1,str2第一个相同，那么最长公共子序列是1
		for(int i=1;i<str2.length;++i) {
			dp[0][i]=Math.max(dp[0][i-1],str1[0]==str2[i]?1:0);//当str1[0]！=str2[i],有可能dp[i-1][0]=1
		}
		for(int i=1;i<str1.length;++i) {
			dp[i][0]=Math.max(dp[i-1][0],str1[i]==str2[0]?1:0);
		}
		for(int i=1;i<str1.length;i++) {
			for(int j=1;j<str2.length;j++) {
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);//公共子序列是str1[0~i-1]str2[0~j]或str1[0~i]str2[0~j-1]
				if(str1[i]==str2[j])
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]+1);
			}
		}
		return dp;
	}

}
