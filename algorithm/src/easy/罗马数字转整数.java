package easy;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {

	public static void main(String[] args) {
		init();
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
	}
	//映射表
	private static Map<Character,Integer> map=new HashMap<>();
	
	private static void init() {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	/**
	 * 如果后一位比前一位大，说明要减去。如：IV对应的是4
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		int res=0;
		if(s==null||s.length()==0)return 0;
		char[] c=s.toCharArray();
		for(int i=0;i<c.length;i++) {
			if(i<c.length-1&&map.get(c[i+1])>map.get(c[i]))
				res-=map.get(c[i]);
			else
				res+=map.get(c[i]);
		}
		return res;
	}

}
