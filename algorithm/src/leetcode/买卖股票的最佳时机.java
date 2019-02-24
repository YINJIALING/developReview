package leetcode;

public class 买卖股票的最佳时机 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {7,6,4,3,1};
		System.out.println(maxProfit(arr));
	}
/**
 * arr是第i天获得的利润	
 * @param prices
 * @return
 */
public static int maxProfit(int[] prices) {
	if(prices==null||prices.length==0)
		return 0;
      int[] arr=new int[prices.length];
      arr[0]=0;
      int max=0;
      int sum=0;
      for(int i=1;i<arr.length;i++) {
    	  	arr[i]=prices[i]-prices[i-1];
      }
      for(int i=0;i<arr.length;i++) {
    	  sum+=arr[i];
    	  if(sum>max)
    		  max=sum;
    	  else if(sum<0)
    		  sum=0;
      }
      return max;
    }

}
