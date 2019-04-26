package leetcode;

public class 在排序数组中查找元素的第一个和最后一个位置 {

	public static void main(String[] args) {
		int[] res=searchRange(new int[] {1},1);
		for(int index:res)
			System.out.print(index+",");
	}

	/**
	 * 二分查找
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int res[]=new int[2];
		res[0]=-1;res[1]=-1;
		if(nums==null||nums.length==0)return res;
		int minValue=nums[0],len=nums.length,maxValue=nums[len-1],midvalue=nums[len/2],index=0,start=0,end=0,count=0;
		
		if(target>maxValue||target<minValue) {
			
			return res;
		}
		index=0;
		
		while(index<len&&target>=minValue&&target<=midvalue&&nums[index]<=target) {
			if(nums[index]==target) {
				if(count==0)
					start=index;
				index++;
				count++;
			}else if(nums[index]>target)
				break;
			else
				index++;
		}
		while(target==midvalue&&index<len&&
				nums[index]==target) {
			if(nums[index]==target) {
				index++;
			}else if(nums[index]>target)
				break;
		}
		end=index-1;
		if(count!=0) {
			res[0]=start;res[1]=end;
			return res;
		}
		//后半部分
		index=len/2;
		count=0;
		while(target<=maxValue&&target>=midvalue&&index<len&&nums[index]<=target) {
			if(nums[index]==target) {
				if(count==0)
					start=index;
				index++;
				count++;
			}else if(nums[index]>target) {
				break;
			}	
			else
				index++;
		}
		while(index<len&&target==midvalue&&nums[index]==target&&index>=0) {
			if(nums[index]==target) {
				index--;
			}else if(nums[index]>target)
				break;
		}
		end=index-1;
		if(count!=0) {
			res[0]=start;res[1]=end;
			return res;
		}
		return res;
	}

}
