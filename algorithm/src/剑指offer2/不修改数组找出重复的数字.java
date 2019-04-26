package 剑指offer2;

public class 不修改数组找出重复的数字 {

	public static void main(String[] args) {
		System.out.println(duplicate(new int[] {2,3,5,4,3,2,6,7},8));
	}
	/**
	 * 二分查找
	 * 1.numbers的所有数都在start到end范围之中(start=1,end=length-1),
	 * 2.统计start--mid中的数出现的次数count，如果count>mid-start+1, 说明在start--mid之中有重复的数字，接下来统计start-- mid/2以及mid/2+1——mid之间的数字出现次
	 * 3.当范围缩小到start==end,也就是统计一个数字的出现次数，当count>1说明他就是重复的那个数，
	 * @param numbers
	 * @param length
	 * @return
	 */
	public static int duplicate(int numbers[],int length) {
		int start=1,end=length-1,mid;
		while(start<=end) {
			mid=start+((end-start)>>1);
			int count=countRange(numbers,length,start,mid);
			if(end==start) {
				
				if(count>1)return start;
//				else break;
			}
			if(count>(mid-start+1)) {
				end=mid;
			}
			else {
				start=mid+1;
			}
		}
		return -1;
	}
	//统计在start-end范围内在numbers出现的次数
	private static int countRange(int[] numbers, int length, int start, int end) {
		int count=0;
		for(int index:numbers)
			if(index>=start&&index<=end)count++;
		return count;
	}

}
