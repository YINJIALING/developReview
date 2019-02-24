package 程序员面试经典;
//https://www.cnblogs.com/conw/p/5896155.html
public class 最大连续数列和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {56,-88};
		System.out.println(getMaxSum(arr,2));
	}
	/**
	 * 动归
	 * 如果当前和<0且（当前和-1）>0，说明和需要归零
	 * 如果当前和>max，更新最大值
	 * @param A
	 * @param n 数组大小
	 * @return
	 */
public static int getMaxSum(int[] A, int n) {
	if(A==null||n==0)
		return 0;
	if(A.length==1)
		return A[0];
       int sum=0;
       int max=0;
       for(int i=0;i<A.length;i++) {
    	   sum+=A[i];
    	   if(sum<0)
    		   sum=0;
    	   if(sum>max)
    		   max=sum;
       }
       return max;
    }

}
