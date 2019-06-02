package 剑指offer2;
import java.util.Arrays;
import java.util.Comparator;

public class 把数组排成最小的数 {

	public static void main(String[] args) {
		System.out.println(PrintMinNumber(new int[] {3,32,321}));
		

	}
	/*
	 * 1.将整型数组转为字符串数组strnumbers
	 * 2.根据一定规则将strnumbers排序
	 * (规则是：如果m和n能构成nm和mn,如果mn>nm返回nm,反之返回mn)
	 * 3.将排序好的数组转为最后的结果
	 */
	public static String PrintMinNumber(int [] numbers) {
		if(numbers==null||numbers.length==0)
			return "";
		StringBuilder str=new StringBuilder();
		String[] strnumbers=new String[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			strnumbers[i]=numbers[i]+"";
		}
		Arrays.sort(strnumbers,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String converted1and2=o1+o2;
				String converted2and1=o2+o1;
				return converted1and2.compareTo(converted2and1);
			}
		});
		
		for(String index:strnumbers)
			str.append(index);
		return str.toString();
		
    }

}
