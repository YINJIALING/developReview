package 左程云.递归和动态规划;

public class 数字字符串转换为字母组合的种数 {

	public static void main(String[] args) {
		System.out.println(num("1111"));
	}

	private static int num(String str) {
		char[] chs=str.toCharArray();
		return process(chs,0);
	}

	private static int process(char[] chs, int i) {
		if(i==chs.length)return 1;
		if(chs[i]=='0')return 0;
		int res=process(chs,i+1);
		if(i+1<chs.length&&(chs[i]-'0')*10+chs[i+1]-'0'<27)
			res+=process(chs,i+2);
		return res;
	}

}
