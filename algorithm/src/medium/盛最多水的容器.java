package medium;

public class 盛最多水的容器 {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}

	/**
	 * 1.两个 指针i，j.初始化i=0,j=height.length-1
	 * 2.当前面积tmp=min(height[i],height[j])*差
	 * 3.将当前面积tmp与max比较，如果tmp>max则更新max;
	 * 4.长度变短，想要获得最大面积，需扩大宽，即寻找高的柱子
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int max=Integer.MIN_VALUE,i=0,j=height.length-1;
		while(i<j) {
			int tmp=Math.min(height[i],height[j])*(j-i);
			max=tmp>max?tmp:max;
			if(height[i]>height[j])j--;
			else i++;
		}
		return max;
	}

}
