package easy;

public class 移除元素 {
	public static void main(String[] args) {
		System.out.println(" res:"+removeElement(new int[] {3,2,2,3},3));
		System.out.println(" res:"+removeElement(new int[] {0,1,2,2,3,0,4,2},2));
	}

	/**
	 * 把所有不等于val的数字移至index之前
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int index=0;
		
		if(nums.length>0) {
			for(int i=0;i<nums.length;i++) {
				if(val!=nums[i]) {
					nums[index++]=nums[i];
				}
			}
			print(nums);
			
		}
		
		return index;
	}
	
	public static void print(int[] nums) {
		for(int i:nums) {
			System.out.print(i+" ");
		}
	}
}
