package 左程云.递归和动态规划;

public class 龙与地下城游戏问题 {

	public static void main(String[] args) {
		System.out.println(getMinHp(new int[][] {{-2,-3,3},{-5,-10,1},{0,30,-5}}));

	}

	/**
	 * 注意条件至少有1点血
	 * dp[i][j]走到m[i][j]需要的最小血量
	 * dp[i][j]=min(dp[i-1][j],dp[i][j-1])+m[i][j]
	 * @param m
	 * @return
	 */
	private static int getMinHp(int[][] m) {
		int row=m.length,col=m[0].length;
		int[][] dp=new int[row][col];row--;col--;
		dp[row][col]=m[row][col]>0?1:0-m[row][col]+1;
		//从右下角往前走,最小血量要么是1，要么是上一步的血量-本部需要的
		for(int j=col-1;j>=0;j--) {
			dp[row][j]=dp[row][j+1]-m[row][j]>1?dp[row][j+1]-m[row][j]:1;
		}
		//从右下角往上走,最小血量要么是1，要么是上一步的血量-本部需要的
		for(int j=row-1;j>=0;j--) {
			dp[j][col]=dp[j+1][col]-m[j][col]>1?dp[j+1][col]-m[j][col]:1;
		}
		int right=0,down=0;//向右，向下
		for(int i=row-1;i>=0;i--) {
			for(int j=row-1;j>=0;j--) {
				right=Math.max(1, dp[i][j+1]-m[i][j]);
				down=Math.max(dp[i+1][j]-m[i][j], 1);
				dp[i][j]=Math.min(right, down);
			}
		}
		return dp[0][0];
	}

}
