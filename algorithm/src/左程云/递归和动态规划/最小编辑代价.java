package 左程云.递归和动态规划;

public class 最小编辑代价 {

	public static void main(String[] args) {
		System.out.println(minCost("abc","adc",5,3,2));

	}

	/**
	 * dp[i][j]:把str1[0~i-1]变成str2[0~j-1]的最小代价
	 * @param str1
	 * @param str2
	 * @param ic insert one
	 * @param dc delete one
	 * @param rc replace one
	 * @return
	 */
	private static int minCost(String str1, String str2, int ic, int dc, int rc) {
		int rows=str1.length()+1,cols=str2.length()+1;
		int[][] dp=new int[rows][cols];
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		//初始化：从str1[0~i-1]变成str2[0]，需要加入i个，代价是ic*i
		for(int i=1;i<=str2.length();i++) {
			dp[0][i]=ic*i;
		}
		//初始化：str1[0]变成str2[0~i-1]，需要删除i个，代价是dc*i
		for(int i=1;i<=str1.length();i++) {
			dp[i][0]=dc*i;
		}
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				if(chs1[i-1]==chs2[j-1])
					dp[i][j]=dp[i-1][j-1];//相等，说明不用更改
				else
					dp[i][j]=dp[i-1][j-1]+rc;//只要更改一个字符就行
				dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+ic);//增加一个
				dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+dc);//删除一个
			}
		}
		return dp[rows-1][cols-1];
	}

}
