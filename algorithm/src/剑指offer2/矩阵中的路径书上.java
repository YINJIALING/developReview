package 剑指offer2;

public class 矩阵中的路径书上 {

	public static void main(String[] args) {
		System.out.println(hasPath(new char[] {'a','b','c','e','s','f','c','s','a','d','e','e'}
		,3,4,new char[] {'a','b','c','b'}));

	}

	/**
	 * 回溯---》将路径看成栈
	 * 在矩阵中定位了路径前n个字符之后，在与第n个字符的格子周围都没找到与第n+1个字符，只好回到 第n-1个字符上，重新定位
	 * 
	 * 用一个visited标记路径是否已经进入每个格子
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param str
	 * @return
	 */
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean visited[]=new boolean[rows*cols];
		int pathLength=0;
		for(int row=0;row<rows;row++) {
			for(int col=0;col<cols;col++) {
				if(hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)) {
					return true;
				}
				}
		}
		return false;
	}

	private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
			boolean[] visited) {
		if(str.length==pathLength)return true;
		boolean hasPath=false;
		if(row>=0&&row<rows&&col>=0&&col<cols&&matrix[row*cols+col]==str[pathLength]&&!visited[row*cols+col]) {
			pathLength++;
			visited[row*cols+col]=true;
			hasPath=hasPathCore(matrix,rows,cols,row+1,col,str,pathLength,visited)||
					hasPathCore(matrix,rows,cols,row-1,col,str,pathLength,visited)||
					hasPathCore(matrix,rows,cols,row,col+1,str,pathLength,visited)||
					hasPathCore(matrix,rows,cols,row,col-1,str,pathLength,visited);//递归
			
			if(!hasPath) {
				pathLength--;//回溯
				visited[row*cols+col]=false;
			}
		}
		return hasPath;
	}

}
