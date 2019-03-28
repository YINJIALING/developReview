package medium;

public class 递增的三元子序列 {

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] {1,2,3,4,5}));

	}
	public static boolean increasingTriplet(int[] nums) {
		if(nums.length<3)return false;
		//贪心法，记录最小值和次小值
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int m1=0;// 记录最小值的坐标和次小值的坐标
        int m2=0;
        for(int i=0;i<nums.length;i++) {
        		if(nums[i]<min1) {//更新最小值
        			min1=nums[i];
        			m1=i;
        		}else if(nums[i]>min1&&nums[i]<=min2&&i>m1){
        			min2=nums[i];//更新次小值
        			m2=i;
        		}else if(nums[i]>min2&&i>m2){
        			return true; //当前数比次小值大，说明存在递增的三元组
        		}
        			
        }
        return false;
    }

}
