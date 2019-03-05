package medium;



public class 最大数 {

	public static void main(String[] args) {
//		System.out.println(largestNumber(new int[]{10,2}));
//		System.out.println(largestNumber(new int[]{3,30,34,5,9}));
		System.out.println(largestNumber(new int[]{121,12}));
		
	}

	/**
	 * 对数字进行比较排序，比较方法是 最高位大的算大 最高位相同的，比较次高位，如果次高位没有则次高位有的和上一高位比 因此 34排在3之前，30排在3之后。
	 * @param nums
	 * @return
	 */
	public static String largestNumber(int[] nums) {
		StringBuffer res=new StringBuffer();
		//使数组按照自定义规则有序
		nums=sort(nums);
		for(int i:nums) {
			res.append(i);
		}
		
		return res.toString();

	}
	
	private static int[] sort(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				System.out.println(nums[i]+" "+nums[j]+" "+isBigger(nums[i],nums[j]));
				if(!isBigger(nums[j],nums[j+1])) {
					int tmp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=tmp;
				}
			}
		}
		
		print(nums);
		return nums;
	}
	
	// 最高位大的算大 最高位相同的，比较次高位，如果次高位没有则次高位有的和上一高位比 因此 34排在3之前，30排在3之后
	//nums[i]>nums[j]:return true;
	private static boolean isBigger(int a,int b) {
 		String a_str=a+"";
		String b_str=b+"";
		while(a_str.length()>=1&&b_str.length()>=1) {
			if(a_str.charAt(0)>b_str.charAt(0))return true;//最高位大的返回结果
			else if(a_str.charAt(0)==b_str.charAt(0)){//比较次高位
				if(a_str.length()>1)
					a_str=a_str.substring(1, a_str.length());
				else a_str="";
				if(b_str.length()>1)
					b_str=b_str.substring(1, b_str.length());
				else b_str="";
			}else {
				return false;//最高位小的返回结果
			}	
		}
		
		//a_str或b_str的长度小于1才进入这里
		//先处理末尾为0的情况
		if(a_str.length()>0) {//30,3return 3>30
			if(a_str.charAt(a_str.length()-1)=='0') {
				return false;//3
			}else {
				return true;//34,3比较的情况
			}			
		}else if(b_str.length()>0){
			if(b_str.charAt(0)=='0')return true;
			else return false;
		}else {
			return false;
		}
		
	}
	
	private static void print(int[] nums) {
		for(int i:nums) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
