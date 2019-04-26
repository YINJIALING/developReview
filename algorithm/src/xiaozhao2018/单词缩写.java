package xiaozhao2018;

import java.util.Scanner;

public class 单词缩写 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String[] inputs=new String[n];
		
		for(int i=0;i<n;i++) {
			inputs[i]=in.next();
		}
		for(int i=0;i<n;i++) {
			System.out.println(easy(inputs[i]));
		}
		
	}

	private static String easy(String word) {
		int len=word.length();
		if(len<10)return word;
		
		//处理的是超过10，即大于等于10的情况
		return word.substring(0, 1)+(len-2)+word.substring(len-1);
		
	}

}
