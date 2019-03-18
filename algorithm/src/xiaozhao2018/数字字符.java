package xiaozhao2018;

import java.util.Arrays;
import java.util.Scanner;

public class 数字字符 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.nextLine().toString();
		System.out.println(test(s));
	}

	/**
	 * 1.先排序
	 * 2.if(num[0]!=1&&num[0]!=0)return 1;if(num[0]!=0)return (num[0]+"0");if(num[0]==0&&num包括所有数)那么所有数都能组成；if(num[0]==0&&num不包括所有数)那么返回最小的不包括那个值
	 * @param s
	 * @return
	 */
	private static int test(String s) {
		if(s.length()==0)return 0;
		int[] num=new int[s.length()];
		char c[]=s.toCharArray();
		
		for(int i=0;i<num.length;i++) {
			num[i]=Integer.parseInt(c[i]+"");
		}
		Arrays.sort(num);
		
		if(num[0]!=1&&num[0]!=0)return 1;
		if(num[0]!=0)return Integer.parseInt(num[0]+"0");
	
		if(num[0]==0) {
			for(int i=0;i<num.length-1;i++) {
				if(num[i+1]-num[i]>1) {
					return num[i]+1;
				}
			}
			return 1;	
			
		}
		return 0;	
	}

}
