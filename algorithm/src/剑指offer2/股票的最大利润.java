package 剑指offer2;

public class 股票的最大利润 {

	public static void main(String[] args) {
		int value=getMaxValue(new int[] {9,11,8,5,7,12,16,14});
		System.out.println(value);
	}

	/**
	 * 对于第i个数来说，他获得最大利润可以这样计算：
	 * 从前面第 i-1个数中，寻找最小值
	 * 最大利润=当前值-最小值
	 * 更新最大利润
	 * @param is
	 * @return
	 */
	private static int getMaxValue(int[] number) {
		int min=number[0];
		int maxDiff=number[1]-min;
		for(int i=2;i<number.length;i++) {
			min=min>number[i-1]?number[i-1]:min;
			int curDiff=number[i]-min;
			maxDiff=maxDiff>curDiff?maxDiff:curDiff;
		}
		return maxDiff;
	}

}
