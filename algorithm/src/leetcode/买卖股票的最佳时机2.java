package leetcode;

public class 买卖股票的最佳时机2 {

	public static void main(String[] args) {
		int[] arr1= {7,1,5,3,6,4};
		int[] arr2= {1,2,3,4,5};
		System.out.println(maxProfit(arr1));
		System.out.println(maxProfit(arr2));
	}

	public static int maxProfit(int[] prices) {
       int sum=0;
       
       //如果明天的价格比今天高，就买今天的股票，明天卖
       for(int i=0;i<prices.length-1;i++) {
    	   	if(prices[i+1]-prices[i]>0) 
    	   		sum+=(prices[i+1]-prices[i]);		
       }
       return sum;
    }
}
