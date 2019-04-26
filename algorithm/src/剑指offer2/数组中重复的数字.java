package 剑指offer2;
/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 * @author yinjialing
 *
 */

public class 数组中重复的数字 {

	public static void main(String[] args) {
		int[] res=new int[1];
		System.out.println(duplicate(new int[] {2,3,1,0,2,5,3},7,res));
		System.out.println("the same number is "+res[0]);
	}
	
	//1.先排序，从头到尾扫一遍O(nlogn)
	//2.hashMap，空间复杂度O(n)时间复杂度O(n) 
	/**
	 * 时间复杂度  O(n)
	 * 因为数字的范围在0——n-1内，若无重复数字，排序之后的i就在i的下标下
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		int i=0;
		while(i<length) {
			if(i==numbers[i]) i++;
			else {
				//发现相同数字
				if(numbers[numbers[i]]==numbers[i]) {
					duplication[0]=numbers[i];
					return true;
				}else {
					 //交换i,numbers[i]处的数字
					int tmp=numbers[numbers[i]];
					numbers[numbers[i]]=numbers[i];
					numbers[i]=tmp;
				}
			}
		}
		return false;
	    
    }
	

}
