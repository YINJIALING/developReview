package leetcode;

public class 搜索旋转排序数组 {

	public static void main(String[] args) {
		int[] nums= {5,1,3};
		System.out.println(search(nums,3));
	}
	 public static int search(int[] nums, int target) {
		 if(nums==null||nums.length==0)return -1;
	        int start=0;
	        int mid=nums.length>>1;
	        int tmp=start;
	        if(nums[start]==target)return start;
	        if(nums[mid]==target)return mid;
	        if(target<nums[start]) {
	        	if(target<nums[mid]) {
	        		//从后半部分开始搜索
	        		tmp=mid;
	        		while(tmp<nums.length) {
	        			if(nums[tmp]==target)return tmp;
	        			tmp++;
	        		}
	        		if(tmp==nums.length)return -1;
	        	}else {
	        		//从前半部分开始搜索
	        		while(tmp<mid) {
	        			if(nums[tmp]==target)return tmp;
	        			tmp++;
	        		}
	        		if(tmp==mid)return -1;
	        	}
	        }else {
	        	//需要全局遍历
	        	while(tmp<nums.length) {
	        		if(nums[tmp]==target)return tmp;
	        		tmp++;
	        	}
	        }
	        return -1;
	    }

}
