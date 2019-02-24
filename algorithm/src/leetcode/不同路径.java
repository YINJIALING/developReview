package leetcode;

public class 不同路径 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,2));
	}
	
	public static int uniquePaths(int m, int n) {
       int[][] dp=new int[m][n];
       dp[0][0]=1;
       for(int i=1;i<m;i++) {
    	   	dp[i][0]=1;
       }
       for(int i=1;i<n;i++) {
   	   	dp[0][i]=1;
      }
       for(int i=1;i<m;i++) {
    	   	for(int j=1;j<n;j++) {
    	   		dp[i][j]=dp[i-1][j]+dp[i][j-1];
    	   	}
       }
       return dp[m-1][n-1];
    }

}
