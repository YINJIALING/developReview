package 左程云.递归和动态规划;

public class 换钱的方法数 {

	public static void main(String[] args) {
		System.out.println(coin(new int[] {5,10,25,1},15));

	}

	/*
	 * 对于dp[i][j]:对于arr[i]换成j能组成的换钱方法数
	 * dp[i][j]=dp[i-1][j]完全不要arr[i]
	 * dp[i][j]=dp[i-1][j-n*arr[i]]用了n个arr[i] 
	 */
	private static int coin(int[] arr, int aim) {
		int length=arr.length;
		int[][] dp=new int[length][aim+1];
		//初始化1.换成0元只有1种方法
		for(int i=0;i<length;i++)
			dp[i][0]=1;
		//初始化2.i=0,如果i是arr[0]的倍数,那么就有1种,如：arr[0]=5,那么可以换成5，10，15，。。。都是1种
		for(int i=1;arr[0]*i<=aim;++i) {
			dp[0][arr[0]*i]=1;
		}
		for(int i=1;i<length;++i) {
			for(int j=1;j<=aim;j++) {
				int num=0;
				for(int n=0;j-n*arr[i]>=0;n++) {
					num+=dp[i-1][j-n*arr[i]];
				}
				dp[i][j]=num;
			}
		}
		return dp[length-1][aim];
	}
	
	

}
