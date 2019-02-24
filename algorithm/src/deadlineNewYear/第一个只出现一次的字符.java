package deadlineNewYear;

import java.util.HashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {

	public static void main(String[] args) {
		System.out.println(FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
		System.out.println(FirstNotRepeatingChar2("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
	}
	
	/**
	 * 因为map是无序的，有bug
	 * @param str
	 * @return
	 */
	public static int FirstNotRepeatingChar(String str) {
		if(str==null||str.length()==0)
			return -1;
		char[] array=str.toCharArray();
		Map<Character,Integer> map=new HashMap<>();
		//k:字符，v：出现的次数
		for(char c:array) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}

		char res=0;
		for(Character c:map.keySet()) {
			if(map.get(c).equals(1))
				res=c;
		}
		for(int i=0;i<array.length;i++) {
			if(res==array[i]) {
				return i;
			}
		}
        return -1;
    }
	/**
	 * 使用数组模拟map
	 * @param str
	 * @return
	 */
	public static int FirstNotRepeatingChar2(String str) {
		if(str==null||str.length()==0)
			return -1;
		char[] array=str.toCharArray();
		int[] map=new int[256];//字符的范围是-128到127,
		for(int i=0;i<array.length;i++) {
			map[hash(array[i])]++;
		}
		
		int index=-1;//要返回的坐标
		for(int i=0;i<array.length;i++) {
			if(map[hash(array[i])]==1) {
				index=i;
				break;
			}
				
		}
		return index;
	}

	private static int hash(char c) {
		//为字符建立哈希映射，映射array的数组下标
		//下标：字符，值：出现的次数
		return c+128;
	}

}
