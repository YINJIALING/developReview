package 左程云.递归和动态规划;

public class 换钱的最小货币数 {

	public static void main(String[] args) {
		
		System.out.println(charge(new int[] {5,2,3},20));
	}

	/**
	 * 完全背包
	 * 初始化：当i=0,aim递增的时候
	 * dp[i][j]:对于数组arr[i]生成j需要的最小张数
	 * 不用arr[i]:dp[i][j]=dp[i-1][j]
	 * 用了arr[i] n张:dp[i][j]=dp[i-1][j-n*arr[i]]+n
	 * j-n*arr[i]>=0
	 * @param arr
	 * @param aim
	 * @return
	 */
	private static int charge(int[] arr, int aim) {
		int[][] dp=new int[arr.length][aim+1];
		int max=Integer.MAX_VALUE;
		for(int j=1;j<=aim;j++) {
			dp[0][j]=max;//当i=0时，令生成j的最小张数为最大值，即永远不可能达到
			//如果aim>arr[0]且aim-arr[0]还没被赋值为最大值，就令他的最小张数=aim-arr[0]对应的张数+1
			if(j-arr[0]>=0&&dp[0][j-arr[0]]!=max) {
				dp[0][j]=dp[0][j-arr[0]]+1;
			}
		}

		for(int i=1;i<arr.length;++i) {
			for(int j=1;j<=aim;j++) {
				int n=0;
				for(int z=0;z<j&&j-z*arr[i]>=0;++z) {
					int value=dp[i-1][j-n*arr[i]];
					if(value!=max)
						dp[i][j]=dp[i-1][j-n*arr[i]]+n;
				}
			}
		}
		return dp[arr.length-1][aim];
	}
	

}
