package 剑指offer2;

public class n个骰子的点数 {
	public static void main(String[] args) {
		
		printProbabilty(3);
	}
	protected static void printProbabilty(int n) {
		//结果，对于和最小为n最大为6n,声明一个长度为5n+1的数组用来存每个结果的概率
		String[] result=new String[6*n-n+1];
		//1.计算n个骰子(有6面)的和有多少种可能性
		int total=(int) Math.pow(6, n);
		//2.用动归求c个骰子点数为k,的次数
		int[][] dp=new int[n+1][6*n+1];
		//初始化，dp(1,1)=dp(1,2)=dp(1,3)=dp(1,4)=dp(1,5)=dp(1,6)=1
		for(int x=1;x<=6;++x) {
			dp[1][x]=1;
		}
		//开始计算
		for(int x=2;x<=n;++x) {
			for(int y=2;y<=x*6;++y) {
				int sum=0;
				for(int m=1;m<y&&m<=6;++m) {
					sum+=dp[x-1][y-m];
				}
				dp[x][y]=sum;
			}
		}
		//统计结果
		for(int i=n;i<=6*n;i++) {
			result[i-n]=dp[n][i]+"/"+total;
		}
		
		for(int i=0;i<=5*n;++i) {
			System.out.print(result[i]+",");
		}
	}


}