package xiaozhao2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 删除重复字符 {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		String s=in.nextLine();
		System.out.println(test(s));
	}

	private static String test(String s) {
		StringBuffer resBuffer=new StringBuffer();
		Map<Character,Integer> countMap=new HashMap<>();
		char[] c=s.toCharArray();
		for(int i=0;i<c.length;i++) {
			if(!countMap.containsKey(c[i])) {
				countMap.put(c[i], 1);
				resBuffer.append(c[i]);
			}	
		}
		return resBuffer.toString();
	}

}
