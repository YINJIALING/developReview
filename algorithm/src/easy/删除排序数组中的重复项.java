package easy;

public class 删除排序数组中的重复项 {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2}));
		System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
	}

/**
 * 只需要返回不重复的数组的长度，因而不需要改变数组的大小，只需要计算不重复数字的个数
 * 两个指针：i,index。
 *	index记录所有不重复的元素
 *	i遍历数组
 *	把所有不重复的数组元素提到前面，返回Index即可
 * @param nums
 * @return
 */
			
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0)return 0;
		int index=0;
		
		for(int i=1;i<nums.length;i++) {
			if(nums[index]!=nums[i]) {
				nums[++index]=nums[i];
			}
		}
		index++;
		return index;
	}

}
