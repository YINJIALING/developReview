package leetcode;

public class 摆动序列 {

	public static void main(String[] args) {
		System.out.println(wiggleMaxLength(new int[] {0,0}));
//		System.out.println(wiggleMaxLength(new int[] {1,7,4,9,2,5}));
//		System.out.println(wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
	}

	public static int wiggleMaxLength(int[] nums) {
		int numsSize=nums.length;
		if(nums.length<2)return numsSize;
		int result=0,lastIndex=0;
		result=1;
		for(int index=1;index<numsSize;index++) {
			if(nums[index]>nums[lastIndex]) {
				lastIndex=index;
				while(index+1<numsSize&&nums[index+1]>=nums[lastIndex]) {
					index++;
					lastIndex=index;
				}
				result+=1;
			}else {
				lastIndex=index;
				while(index+1<numsSize&&nums[index+1]<=nums[lastIndex]) {
					index++;
					lastIndex=index;
				}
				result+=1;
			}
		}
		return result;
		
	}

}
