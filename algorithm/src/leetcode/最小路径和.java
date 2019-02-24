package leetcode;

public class 最小路径和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(arr));
	}
	
	public static int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        //第0列的值只能从最左往下一步步走
        for(int i=1;i<grid[0].length;i++) {
        		dp[0][i]=dp[0][i-1]+grid[0][i];
        }
      //第0行的值只能从最左往右一步步走
        for(int i=1;i<grid.length;i++) {
    		dp[i][0]=dp[i-1][0]+grid[i][0];
    }
        //已经处理完i=0和j=0的情况了，可以从1开始，且下面不用判空
        for(int i=1;i<grid.length;i++) {
        	for(int j=1;j<grid[i].length;j++) {
        			dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
        	}
        }
        return dp[grid.length-1][grid[0].length-1];
    }

}
