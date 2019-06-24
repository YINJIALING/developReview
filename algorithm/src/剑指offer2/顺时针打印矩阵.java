package 剑指offer2;

import java.util.ArrayList;

public class 顺时针打印矩阵 {

	public static void main(String[] args) {
		ArrayList<Integer> list=printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
		for(Integer index:list) {
			System.out.print(index+",");
		}

	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
	}

}
