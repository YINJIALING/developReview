package leetcode;
/**
 * http://chengfeng96.com/blog/2017/08/07/LeetCode-No-44-Wildcard-Matching/
 * @author yinjialing
 *
 */
public class 通配符匹配 {

	public static void main(String[] args) {
//		System.out.println(isMatch("aa","a"));
//		System.out.println(isMatch("cb","?a"));
		System.out.println(isMatch2("adceb","*a*b"));
	}

	//动态规划
	/**
	 * 设dp[i][j]表示p(0,i+1)是否能与s(0,j+1)完全匹配
	 * 1.初始化
	 *   1).空字符串与空字符串匹配为true，也就是dp[0][0]=true
	 *   2).空字符串与非空的模式匹配，dp[i][0]=dp[i-1][0]&&p[i]=='*'
	 * 2.递推表达式
	 *  要使dp[i][j]==true，则有以下三种情况
	 *   1).dp[i-1][j-1]=true&&s[j]与p[i]相匹配
	 *   2).dp[i][j-1]==true&&p[i]=='*',*对应0个字符
	 *   3).dp[i-1][j]==true&&p[i]=='*',*对应多个字符
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		boolean flagStar=false;//是否p包含*
		for(char c:p.toCharArray()) {
			if(c=='*')flagStar=true;
		}
		//如果p不包括*，且p的长度不等于s的长度，说明肯定不匹配
		if(!flagStar&&s.length()!=p.length())return false;
		boolean[][] dp=new boolean[p.length()+1][s.length()+1];
		dp[0][0]=true;
		for(int i=1;i<=p.length();i++) {
			char p_char=p.charAt(i-1);
			dp[i][0]=dp[i-1][0]&&p_char=='*';
			for(int j=1;j<=s.length();j++) {
				char s_char=s.charAt(j-1);
				dp[i][j]=(dp[i-1][j-1]&&isEqual(s_char, p_char))
						||(dp[i-1][j]&&p_char=='*')||(dp[i][j-1]&&p_char=='*');
			}
		}

		return dp[p.length()][s.length()];
	}
	
	/**
	 * 贪心算法
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch2(String s, String p) {
		if(p.length()==0)return s.length()==0;
		int six=0,pix=0,start=-1,match=0;//start:定位到当前匹配p处，match:定位到当前匹配s处
		while(six<s.length()) {
			if(pix<p.length()&&(s.charAt(six)==p.charAt(pix)||p.charAt(pix)=='?')) {
				six++;pix++;//当遇到相同符号或?时，six,pix右移
			}else if(pix<p.length()&&p.charAt(pix)=='*') {
				start=pix;match=six;pix++;//当遇到*，记录当前的six,pix索引，pix右移（模拟*匹配0个字符）
			}else if(start>-1){
				//不能完成相似匹配且当前p[pix]不是*，说明匹配错误，如果start不等于初始值，则说明已经遇到*，
				//需返回到上次出现的*的地方,再次匹配
				//另*匹配的字符数在原来基础上+1，也就是six=match+1
				//pix指针右移
				six=match+1;pix=start+1;match++;
			}else//不满足上述条件，说明无法匹配
				return false;
		}
		//如果pix后还有*，将其匹配为0个字符，pix直接右移
		while(pix<p.length()&&p.charAt(pix)=='*')pix++;
		//如果pix已经到了最右端，说明匹配成功
		return p.length()==pix;
	}

	private static boolean isEqual(char charAt, char charAt2) {
		if(charAt==charAt2||charAt2=='?')return true;
		return false;
	}

}
