package medium;

import java.util.Random;

public class 打乱数组 {
	public int[] nums;//原数组
	private int[] tmp;
	public 打乱数组(int[] nums) {
		this.nums=nums;
		tmp=nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		for(int i=0;i<nums.length/2;i++) {//随机交换
			//将第0个数与一个随机位置上的数交换
			swap(tmp,0,new Random().nextInt(nums.length));
		}
		return tmp;
	}

	private void swap(int[] tmp, int i, int j) {
		int temp=tmp[i];
		tmp[i]=tmp[j];
		tmp[j]=temp;
	}

}
