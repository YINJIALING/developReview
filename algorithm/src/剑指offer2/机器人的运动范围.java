package 剑指offer2;

public class 机器人的运动范围 {

	public static void main(String[] args) {
		System.out.println(movingCount(18,36,38));

	}
	//计算其所能到达的格子数
	public static int movingCount(int threshold, int rows, int cols)
    {
		boolean visited[][]=new boolean[rows][cols];
		return movingCountCore(threshold,rows,cols,0,0,visited);
    }
	private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		int count=0;
		if(row>=0&&row<rows&&col>=0&&col<cols&&!visited[row][col]&&(getDigitSum(row)+getDigitSum(col))<=threshold) {
			visited[row][col]=true;
			count=1+movingCountCore(threshold,rows,cols,row+1,col,visited)+
					movingCountCore(threshold,rows,cols,row-1,col,visited)+
					movingCountCore(threshold,rows,cols,row,col-1,visited)+
					movingCountCore(threshold,rows,cols,row,col+1,visited);//递归
		}
		return count;
	}
	//得到一个数字其数位的和
	private static int getDigitSum(int number) {
		int res=0;
		while(number>0) {
			res+=(number%10);
			number=number/10;
		}
		return res;
	}

}
