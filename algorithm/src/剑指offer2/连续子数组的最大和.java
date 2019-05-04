package 剑指offer2;

public class 连续子数组的最大和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//根据数组规律
	/**
	 * 发现当前和小于等于0的时候，消去前面的累加结果
	 * 否则继续累加
	 * 更新最大值
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
		if(array==null||array.length==0)
			return 0;
		int nCurSum=0,nGreatestSum=Integer.MIN_VALUE;
		for(int i=0;i<array.length;++i) {
			if(nCurSum<=0)
				nCurSum=array[i];
			else
				nCurSum+=array[i];
			nGreatestSum=nGreatestSum>nCurSum?nGreatestSum:nCurSum;
		}
		return nGreatestSum;
	}
	/**
	 * dp 
	 * f(i)=max(f(i-1)+array[i],array[i])
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray2(int[] array) {
		if(array==null||array.length==0)
			return 0;
		int nGreatestSum=Integer.MIN_VALUE;
		int[] dp=new int[array.length];
		dp[0]=array[0];
		for(int i=1;i<array.length;++i) {
			dp[i]=Math.max(dp[i-1]+array[i], array[i]);
			nGreatestSum=nGreatestSum>dp[i]?nGreatestSum:dp[i];
		}
		return nGreatestSum;
	}

}
