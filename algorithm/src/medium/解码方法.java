package medium;

public class 解码方法 {

	public static void main(String[] args) {
//		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("110"));
//		System.out.println(numDecodings("12"));
	}
	
	/**
	 * 自己未作出
	 * 动态规划，思路参见爬楼梯
	 * 参考链接：https://www.cnblogs.com/tengdai/p/9245714.html
	 * @param s
	 * @return
	 */
    public static int numDecodings(String s) {
    	 if (s == "") return 0;
         char[] digit = s.toCharArray();
         int[] dp = new int[digit.length];
         //get dp[0]
         dp[0] = digit[0] == '0' ? 0 : 1;
         if (dp[0] == 0 || digit.length == 1) return dp[0];
         //get dp[1]
         dp[1] = 1;
         if (digit[1] == '0') {//注意‘0’的情况
             if (digit[0] >= '3')
                 return 0;
         }
         else if (digit[0] == '1' || (digit[0] == '2' && '1' <= digit[1] && digit[1] <= '6'))
                 dp[1] = 2;
         //get dp[i]
         for (int i = 2; i < digit.length; i++) {
             if (digit[i] == '0') {
                 if (digit[i-1] == '1' || digit[i-1] == '2')
                     dp[i] = dp[i-2];
                 else return 0;
             }
             else if (digit[i-1] == '1' || (digit[i-1] == '2' && '1' <= digit[i] && digit[i] <= '6')) 
                 dp[i] = dp[i-1] + dp[i-2];
             else dp[i] = dp[i-1];
         }
         return dp[digit.length-1];
        
    }

}
