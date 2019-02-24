package leetcode;

public class 不同路径2 {

	public static void main(String[] args) {
		int[][] arr= {{0,0}};
		System.out.println(uniquePathsWithObstacles(arr));
	}
public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
       if(obstacleGrid[0][0]==1)return 0;//左上角是0，哪也去不了，因此返回0
       dp[0][0]=1;
     
       if(obstacleGrid[0].length>=1) {
    	   for(int i=1;i<obstacleGrid[0].length;i++) {
    		   if(obstacleGrid[0][i]==0)
    			   dp[0][i]=1;//第一竖列
    		   else
    			   break;
          }
       }
       
       if(obstacleGrid.length>=1) {
    	   for(int i=1;i<obstacleGrid.length;i++) {
    		   if(obstacleGrid[i][0]==0)
    	   	   	dp[i][0]=1;//第一横行
    		   else
    			   break;/**如{0,0},{1,1},{0,0}第2行被阻塞了，进不来
    			   **/
    	      }
       }
      
       if(obstacleGrid.length>1&&obstacleGrid[0].length>1) {
    	   for(int i=1;i<obstacleGrid.length;i++) {
       	   	for(int j=1;j<obstacleGrid[i].length;j++) {
       	   		dp[i][j]=(obstacleGrid[i][j]==0)?(dp[i][j-1]+dp[i-1][j]):0;
       	   	}
          }
       }
       
       return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

}
