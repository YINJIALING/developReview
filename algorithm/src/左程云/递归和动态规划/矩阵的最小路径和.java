package 左程云.递归和动态规划;

public class 矩阵的最小路径和 {

	public static void main(String[] args) {
		System.out.println(getMinPath(new int[][] {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}}));

	}
	/**
	 * 先初始化
	 * 对于某个位置i,j 最小路径=min(dp(i-1,j),dp(i,j-1))+num(i,j)
	 * @param m
	 * @return
	 */
	public static int getMinPath(int[][] m) {
		int rows=m.length;
		int cols=m[0].length;
		int[][] dp=new int[rows][cols];
		dp[0][0]=m[0][0];
		for(int i=1;i<rows;++i) {
			dp[i][0]=dp[i-1][0]+m[i][0];
		}
		for(int i=1;i<cols;i++) {
			dp[0][i]=dp[0][i-1]+m[0][i];
		}

		for(int i=1;i<m.length;i++) {
			for(int j=1;j<m[i].length;j++) {

				dp[i][j]=m[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);			
				
			}
		}
		return dp[rows-1][cols-1];
	}

}
