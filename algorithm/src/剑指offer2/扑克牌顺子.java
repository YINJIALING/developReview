package 剑指offer2;

import java.util.Arrays;

public class 扑克牌顺子 {

	public static void main(String[] args) {
		
		System.out.println(isContinuous(new int[] {2,5,6,7}));
	}

	/*
	 * 1.先排序
	 * 2.统计0出现的次数
	 * 3.统计gap
	 * 4. 如果gap<0出现的次数,可以
	 */
	public static boolean isContinuous(int[] numbers) {
		if(numbers==null||numbers.length<1)
			return false;
		Arrays.sort(numbers);
		int numberOfZero=0,numberOfGap=0,length=numbers.length;
		
		//统计0出现的次数
		for(int i=0;i<numbers.length&&numbers[i]==0;i++) {
			numberOfZero++;
		}
		//统计gap
		int small=numberOfZero,big=small+1;
		while(big<length) {
			//两个数相等，对子，那么不可能是顺子
			if(numbers[small]==numbers[big])
				return false;
			numberOfGap+=numbers[big]-numbers[small]-1;
			small=big;big++;
		}
		return (numberOfZero>=numberOfGap)?true:false;
	}

}
