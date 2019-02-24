package leetcode;

public class 最长回文子串 {

	public static void main(String[] args) {
		String s1=new String("tattarrattat");
		//System.out.println(longestPalindrome(s1));
		System.out.println(test2(s1));
	}
	
	/**
	 * 动归思想：设dp[i][j]表示从i到j的字符串是回文串
	 * 1.初始化；dp[i][i]=true;dp[i][i+1]=(str[i]==str[i+1])分别表示一个字符串是回文，两个相同的字符是回文
	 * 2.dp[i][j]=true if(dp[i+1][j-1]&&str[i]==str[j])
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		 if(s==null||s.length()==0)return "";
	      if(s.length()==1)return s;
	        int start=0,maxLength=Integer.MIN_VALUE;
	      boolean[][] dp=new boolean[s.length()][s.length()];
	      for(int i=0;i<dp.length;i++) {
	    	  	dp[i][i]=true;
	    	  	if(i<dp.length-1)
	    	  		dp[i][i+1]=true;
	      }
	      for(int i=0;i<dp.length;i++) {
	    	  	//start=i;
	    	  	for(int j=i+1;j<dp[i].length;j++) {
	    	  		if(s.charAt(i)==s.charAt(j)) {
	    	  			if(i<dp.length-1) {
	    	  				dp[i][j]=dp[i+1][j-1];
	    	  				if(dp[i][j]&&maxLength<j-i+1) {
	    	  					maxLength=j-i+1;start=i;
	    	  				}
	    	  				
	    	  			}	
	    	  		}else {
	    	  			dp[i][j]=false;
	    	  		}
	    	  	}
	    	  	
	      }
	      if(maxLength>Integer.MIN_VALUE)
	    	  	return s.substring(start, maxLength+start);
	      else
	    	  	return s.substring(start,start+1);
}
	
	private static String test2(String s) {
		if(s==null||s.length()==0)return "";
	    if(s.length()==1)return s;
	    char[] c=s.toCharArray();
	    int i=1;
	    int start=0,maxLength=Integer.MIN_VALUE;
	    
	    // 长度为奇数的最长回文子串，如:aba
	    while(i<c.length-1) {
	    	int k=i+1;
	    	int j=i-1;
	    		while(j>=0&&i<c.length-1&&k<c.length&&c[j]==c[k]) {
	    			if(maxLength<k-j+1) {
	    				start=j;
		    			maxLength=k-j+1;
	    			}
	    			j--;
	    			k++;
	    		}
	    		i++;
	    }
	    i=0;
	 // 长度为偶数的最长回文子串，如:abba
	    while(i<c.length-1) {
	    	int k=i+1;int j=i;
	    		while(j>=0&&k<c.length&&c[i]==c[k]) {
	    			if(maxLength<k-j+1) {
	    				start=j;
		    			maxLength=k-j+1;
	    			}
	    			j--;
	    			k++;
	    		}
	    		i++;
	    }
	    if(maxLength>Integer.MIN_VALUE)
    	  	return s.substring(start, maxLength+start);
      else
    	  	return s.substring(start,start+1);
	}
	/**
	 * zx
	 * @param s
	 * @return
	 */
	private String methos(String s) {
        int length = s.length();
        int maxLen = 0;
        int start = 0;
        boolean[][] dp = new boolean[50][50]; 
        for(int i=0;i<length;i++){
            dp[i][i] = true;
            if(i<length-1&&s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for(int len = 3;len<length;len++){//子串长度
            for(int i=0;i<=length-len;i++){//子串起始的地址
                int j = i+len-1;//子串结束位置
                if(dp[i+1][j-1]==true&&s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    maxLen = len;
                    start = i;
//                    if(maxLen>=5){
//                        return s.substring(start, start+maxLen);
//                    }
                }
            } 
            
        }
        return s.substring(start, start+maxLen);
	}
	}

