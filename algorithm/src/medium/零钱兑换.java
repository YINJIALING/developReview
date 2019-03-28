package medium;

public class 零钱兑换 {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
	}

	public static int coinChange(int[] coins, int amount) {
		// 完全背包问题：使用dp[i]表示使用coins组成amount所需要的最少硬币数
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				//首先i这个amount需要大于当前拿到的coin, 使用当前coin一个dp[i-coin]可以被coins组成，
				//也就是dp[i-coin]!=-1
				if (i >= coin && dp[i - coin] != -1 && coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
				//如果dp[i]==MAX说明不能使用coins组成这个amount
				if (dp[i] == Integer.MAX_VALUE)
					dp[i] = -1;
			}

		}
		return dp[amount];
	}

}
