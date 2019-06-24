package 左程云.递归和动态规划;

public class 跳跃游戏 {

	public static void main(String[] args) {
		System.out.println(jump(new int[] {3,2,3,1,1,4}));

	}

	/**
	 * 1。先判断arr[i]上跳arr[i]，是否能到达最后的位置上，如果不能到达到就尽可能的多跳
	 * @param is
	 * @return
	 */
	private static int jump(int[] is) {
		int jump=0;//跳的次数
		int cur=0;//跳jump步最远能到达的位置
		int next=0;//再多跳一步，最远能到达的距离
		for(int i=0;i<is.length;i++) {
			if(cur<i) {
				jump++;
				cur=next;
			}
			next=Math.max(next, i+is[i]);
		}
		return jump;
	}

}
