package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {

	public static void main(String[] args) {
		List<List<String>> res = solveNQueens(4);
		for (List<String> tmp : res) {
			System.out.print("{");
			for (String str : tmp) {
				System.out.print(str + ",");
			}
			System.out.println("}");
		}
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] location = new char[n][n];
		int[][] mark = new int[n][n];
		// location初始化全为.，mark初始化全为0
		for (char[] tmp : location) {
			Arrays.fill(tmp, '.');
		}

		//从第0行开始，放置皇后，原因是每行只能放置一个皇后
		solveNQueensCore(0, n, location, res, mark);
		return res;
	}

	/**
	 * 递归+回溯
	 * @param k 当前放置的皇后个数，即第几行
	 * @param n 需要放置的皇后个数
	 * @param location 当前皇后的放置位置
	 * @param res 结果集
	 * @param mark 1标记不能放置皇后的位置，0表示能
	 * 思路：
	 * 1.判断当前位置(i,j)在mark是否可以放置皇后，如果可以，放置皇后location[i][j]=Q并标记mark[i][j]=1，把并根据规则把该位置上8个方向都置为1.记录放置前的布局tmp_mark
	 * 2.在当前位置(i,j)也可以不放皇后，将mark还原成放置之前的位置tmp_mark
	 * 3.递归终止条件：完成了n个皇后的放置，将当前location加入结果集
	 */
	private static void solveNQueensCore(int k, int n, char[][] location, List<List<String>> res, int[][] mark) {

		if (k == n) {// k==n时，完成了从第0行到第n-1行的皇后的放置
			List<String> tmp = new ArrayList<>(); // 将当前位置计入res
			for (int i = 0; i < n; i++) {
				StringBuffer str = new StringBuffer();
				for (int j = 0; j < n; j++) {
					str.append(location[i][j]);
				}
				tmp.add(str.toString());
			}
			res.add(tmp);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (mark[k][i] == 0) {// mark[k][i]=0表示可以放置皇后
				int[][] tmp_mark = copy(mark);// 记录回溯前的mark
				location[k][i] = 'Q';// 记录当前皇后的位置
				putDownQueen(mark, k, i);// 放置皇后
				solveNQueensCore(k + 1, n, location, res, mark);// 递归下一行皇后的放置
				mark = copy(tmp_mark);// 将mark置为回溯前的状态
				location[k][i] = '.'; // 将当前皇后的位置为.
			}
		}
	}

	/**
	 * 深拷贝二维数组
	 * 原因：
	 * 对于二维数组使用clone()依旧是浅拷贝；对于一维数组使用clone()是深拷贝；
	 * 实现方式：
	 * 将每行使用clone()
	 * @param mark
	 * @return
	 */
	private static int[][] copy(int[][] mark) {
		int n=mark.length;
		int[][] copy=new int[n][n];
		for(int i=0;i<n;i++) {
			copy[i]=mark[i].clone();
		}
		return copy;
	}
	/*
	 * 第x行，y列放置皇后，mark表示一张棋盘
	 */
	private static void putDownQueen(int[][] mark, int x, int y) {
		int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
		mark[x][y] = 1;// (x,y)放置皇后，标记

		// 向8个方向延伸，上下左右以及对角线
		for (int i = 1; i < mark.length; i++) {
			for (int j = 0; j < 8; j++) {
				int new_x = x + i * dx[j];
				int new_y = y + i * dy[j];// 每个方向最多延伸至n-1
				if (new_x >= 0 && new_x < mark.length && new_y >= 0 && new_y < mark.length) {
					// 新位置是否还在棋盘中
					mark[new_x][new_y] = 1;
				}
			}
		}

	}

}
