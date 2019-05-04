package medium;

import java.util.Arrays;

public class 零钱兑换 {

	public static void main(String[] args) {
		System.out.println(coinChange2(new int[] { 2,3,6,100,210},11 ));
	}

	public static int coinChange(int[] coins, int amount) {
		// 完全背包问题：使用dp[i]表示使用coins组成amount所需要的最少硬币数
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				//首先i需要大于当前拿到的coin, 使用当前coin一个dp[i-coin]可以被coins组成，
				//也就是dp[i-coin]!=-1
				if (i >= coin && dp[i - coin] != -1 && coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);//取最小值
				}
				
			}
			//如果dp[i]==MAX说明不能使用coins组成这个amount
			if (dp[i] == Integer.MAX_VALUE)
				dp[i] = -1;

		}
		return dp[amount];
	}
	
	/**
	 * 1.优先考虑贪心coins={1,2,5,7,10},amount=14
	 * 若先选10，剩下4，2张2元的，count=3(错)
	 * 若选2张7，count=2，只能用动归
	 * 2.dp
	 * 1）设dp[i]是金额i所需要的最小钱张数,初始化为-1，表示不可构成该值
	 * 2）对于coins={1,2,5,7,10}，dp[2]=1,dp[10]=1
	 * 3）对于其他等于-1的dp,dp[i]=min(dp[i-1],dp[i-2],dp[i-5],dp[i-7],dp[i-10])+1
	 * 首先赋初值
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange2(int[] coins, int amount) {
		int[] dp=new int[amount+1];
		Arrays.fill(dp,-1);
		for(int i=0;i<coins.length;i++) {
			if(coins[i]<=amount)
				dp[coins[i]]=1;
		}
		dp[0]=0;
		for(int i=1;i<=amount;i++) {
			int min=Integer.MAX_VALUE;
			if(dp[i]!=1) {
				for(int j=0;j<coins.length;j++) {
					if(i-coins[j]>=0&&dp[i-coins[j]]!=-1) {
						min=min<dp[i-coins[j]]?min:dp[i-coins[j]];
					}
				}
				if(min>0&&min<Integer.MAX_VALUE)
					dp[i]=min+1;
				else
					dp[i]=-1;
				
			}

		}
		return dp[amount];
	}

}
