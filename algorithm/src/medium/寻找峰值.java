package medium;

public class 寻找峰值 {

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] {1,2
				}));
	}

	public static int findPeakElement(int[] nums) {
		if(nums==null||nums.length==0)return -1;
		if(nums.length==1||nums[1]<nums[0])return 0;
		if(nums[nums.length-2]<nums[nums.length-1])
			return nums.length-1;
		for(int i=1;i<nums.length-1;i++) {
			if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
				return i;
			
		}
		return 0;
	}
	
	//二分
	public static int findPeakElement2(int[] nums) {
		int start=0,end=nums.length-1;
		while(start<=end) {
			int middle=(start+end)>>1;
			if(nums[middle]>nums[middle-1]&&nums[middle]>nums[middle+1])
				return middle;
			
		
		}
		return 0;
	}

}
