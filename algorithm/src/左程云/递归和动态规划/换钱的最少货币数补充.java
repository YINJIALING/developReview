package 左程云.递归和动态规划;

public class 换钱的最少货币数补充 {

	public static void main(String[] args) {
		System.out.println(charge(new int[] {5,2,3,5},10));

	}
	
	/**
	 * 01背包
	 * 对于dp[i][j]:对于arr[i]来说，达到j的最小货币数
	 * dp[i][j]=Min(dp[i-1][j],dp[i-1][j-arr[i]]+1)
	 * @param arr
	 * @param aim
	 * @return
	 */
	private static int charge(int[] arr, int aim) {
		int length=arr.length;
		int max=Integer.MAX_VALUE;
		int[][] dp=new int[length][aim+1];
		for(int i=1;i<=aim;++i) {//注意这里初始化

			dp[0][i]=max;
		}
		if(arr[0]<=aim) 
		{
			dp[0][arr[0]]=1;
		}
		for(int i=1;i<length;i++) {
			for(int j=1;j<=aim;++j) {
				if(j-arr[i]>=0&&dp[i-1][j-arr[i]]!=max)
					dp[i][j]=Math.min(dp[i-1][j],1+dp[i-1][j-arr[i]]);
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[length-1][aim];
	}

}
