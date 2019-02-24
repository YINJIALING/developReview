package deadlineNewYear;
/**
 * 动归
 * @author yinjialing
 *dp[i]=max(dp[i-1]+array[i],array[i]);
 */
public class 连续子数组的最大和 {

	public static void main(String[] args) {
		int[] array= {1,-2,3,10,-4,7,2,-5};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
public static int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0)
        	return 0;
        int res[]=new int[array.length];
        res[0]=array[0];
        for(int i=1;i<res.length;i++) {
        		res[i]=(res[i-1]+array[i])>array[i]?(res[i-1]+array[i]):array[i];
        }
        return getMax(res);
    }
/**
 * 得到数组中最大的值
 * @param array
 * @return
 */
private static int getMax(int[] array) {
	int max=array[0];
	for(int index:array) {
		if(max<index)
			max=index;
	}
	return max;
}

}
