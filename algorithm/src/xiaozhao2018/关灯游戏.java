package xiaozhao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 判断几次能让灯泡全息
 */
public class 关灯游戏 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = 0;
		List<Integer> list = new ArrayList<>(n);
		while (i < n) {
			list.add(in.nextInt());
			i++;
		}
		System.out.println(test(list, n));
	}

	/**
	 * 从一旦有i=1位时候开始让所有灯change，检验每次change的状态，以及记录change的操作人
	 * flag=true说明返回alice,其他的返回bob
	 * @param list
	 * @param n
	 * @return
	 */
	private static String test(List<Integer> list, int n) {
		boolean flag = false;// true:alice
		int i = 0;
		if(check(list))return "Alice";

		while (!check(list) && i < n) {
			if (list.get(i) == 0)
				i++;
			else {
				list = change(list, i);
				flag = !flag;
			}
		}

		if (flag)
			return "Alice";
		else
			return "Bob";
	}

	/**
	 * 根据从传入的list和坐标i将从i开始的所有置反
	 * @param list
	 * @param i
	 * @return
	 */
	private static List<Integer> change(List<Integer> list, int i) {
		for (int index = i; index < list.size(); index++) {
			if (list.get(index) == 0)
				list.set(index, 1);
			else
				list.set(index, 0);
		}
		return list;
	}

	/**
	 * 检查数组的状态
	 * @param list
	 * @return
	 */
	private static boolean check(List<Integer> list) {
		for (Integer i : list) {
			if (i == 1)
				return false;// 有灯亮
		}
		return true;// 所有灯都是熄的
	}

}
