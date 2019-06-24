package leetocde2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * 打乱一个数组的顺序 打乱后，还能返回原数组
 * 
 * @author yinjialing
 *
 */
public class Shuffle_an_Array {
	int[] nums_clone;


	public Shuffle_an_Array(int[] nums) {
		nums_clone = nums.clone();
		
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums_clone;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] res = nums_clone.clone();
		for (int i = res.length - 1; i >= 0; i--) {
			// 初始化一个小于i+1的随机数
			int radomIndex = new Random().nextInt(i + 1);
			// 将随机数radomIndex与下标为i的交换
			int tmp = res[radomIndex];
			res[radomIndex] = res[i];
			res[i] = tmp;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
