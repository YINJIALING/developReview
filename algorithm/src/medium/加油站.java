package medium;

public class 加油站 {

	public static void main(String[] args) {
//		System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(canCompleteCircuit(new int[] {2,3,4}, new int[] { 3,4,3 }));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int count = 0;// 油箱中的油
		int length = gas.length;
		for (int i = 0; i < length; i++) {
			count = gas[i];
			int index = i;
			boolean flag = false;// 用于标志是否进入计算体

			while (index != i || !flag) {
				flag = true;
				count -= cost[index];
				if (count < 0)
					break;
				
				index++;
				if (index >= length) {
					index = 0;
				}
				count += gas[index];
			}
			if(count>0)
				return i;

		}
		return -1;
	}

}
