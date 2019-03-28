package medium;

public class 寻找重复数 {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] {1,3,4,2,2}));
//		System.out.println(findDuplicate(new int[] {3,1,3,4,2}));
	}

	public static int findDuplicate(int[] nums) {
		int fast=1,slow=0;
		int n=nums.length-1;
		while(fast==slow||nums[fast]!=nums[slow]) {
			if(fast+2<=n)
				fast+=2;
			else if(fast==n){
				fast=1;
			}else {
				fast=0;
			}
			if(slow+1<=n)
				slow++;
			else
				slow=0;
		}
		return nums[fast];
	}

}
