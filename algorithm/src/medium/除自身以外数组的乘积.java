package medium;

public class 除自身以外数组的乘积 {

	public static void main(String[] args) {
		print(productExceptSelf(new int[] {1,2,3,4}));
	}

	private static void print(int[] productExceptSelf) {
		for(int index:productExceptSelf) {
			System.out.print(index+" ");
		}
		System.out.println();
	}

	public static int[] productExceptSelf(int[] nums) {
		int left=1,right=1,len=nums.length;
		int[] output=new int[len];
		//相当于一个累积器output[i]=nums[i-1]*....nums[0]
		for(int i=0;i<len;i++) {
			output[i]=left;
			left*=nums[i];
		}
		
		//相当于一个累积器output[i]=output[i]*nums[i+1]*....nums[len-1]
		//=nums[i+1]*....nums[len-1]*nums[i-1]*....nums[0]即可得到答案
		for(int i=len-1;i>=0;i--) {
			output[i]*=right;
			right*=nums[i];
		}
		return output;
	}

}
