package 剑指offer2;

public class 跳台阶 extends 二维数组中的查找 {

	public static void main(String[] args) {
		
		System.out.println(JumpFloor(2));
	}
	/*
	 * 斐波那契数列 
	 * f(n)=f(n-1)+f(n-2) n>1
	 * 当n>2时，第一次跳的时候有两种不同的跳法，
	 * 1.第一次跳1，此时跳法数目=后面n-1的台阶跳法
	 * 2.第一次跳2，此时跳法数目=后面n-2的台阶跳法
	 */
	public static int JumpFloor(int target) {
		if(target==0)return 0;
		if(target==1)return 1;
		if(target==2)return 2;
		return JumpFloor(target-1)+JumpFloor(target-2);
    }

}
