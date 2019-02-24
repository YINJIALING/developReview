package deadlineNewYear;
/**
 *  参考博文：
 *  https://www.cnblogs.com/mthoutai/p/6991118.html
 * @author yinjialing
 *
 */
public class 矩阵中的路径 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="abcesfcsadee";
		char[] matrix= input.toCharArray();
		String res="bcced";
		char[] str= res.toCharArray();
		System.out.println(hasPath(matrix,3,4,str));
	}

	/**
	 * 1.回溯（考虑栈）
	 * 当在第n个字符周围都没找到第n+1个字符，在路径上回到第n-1个字符，又一次查找第n个字符
	 * 2.路径不能反复进入矩阵的格子，需要定义布尔矩阵，用于标志路径是否已经进入格子
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param str
	 * @return
	 */
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix==null||matrix.length==0||str==null||str.length==0)
			return false;
		// 先根据传入的matrix,rows,cols返回对应二维数组
		if(rows!=0&&cols!=0&&str.length!=0) {
			char[][] matrix2 = buildMatrix(matrix, rows, cols);
			int index=0,rowsIndex=0,colsIndex=0;
			//找到第一字符所在的位置
			for(int i=0;i<rows;i++) {
				for (int j = 0; j < cols; j++) {
					if(str[index]==matrix2[i][j]) {
						rowsIndex=i;
						colsIndex=j;
					}		
				}
			}
			return hasPathCore(matrix2,str,rows,cols,rowsIndex,colsIndex,1);
		}
		return false;
	}
	
	private static boolean hasPathCore(char[][] matrix2, char[] str, int rows,int cols, int rowsIndex, int colsIndex,int strIndex) {
		boolean left=false,right=false,top=false,bottom=false;
		if(rowsIndex>=1)
			left=Equal(matrix2, str,rowsIndex-1,colsIndex,strIndex);
		if(rowsIndex!=rows)
			right=Equal(matrix2, str,rowsIndex+1,colsIndex,strIndex);
		if(colsIndex>=1)
			top=Equal(matrix2,str,rowsIndex,colsIndex-1,strIndex);
		if(colsIndex!=cols)
			bottom=Equal(matrix2,str,rowsIndex,colsIndex+1,strIndex);
		if(left||right||top||bottom) {
			strIndex++;
			if(strIndex==str.length)
				return true;
			//继续比较
			if(left)
				return hasPathCore(matrix2,str,rows,cols,rowsIndex-1,colsIndex,strIndex);
			if(right)
				return hasPathCore(matrix2, str,rows,cols,rowsIndex+1,colsIndex,strIndex) ;
			if(top)
				return hasPathCore(matrix2,str,rows,cols,rowsIndex,colsIndex-1,strIndex);
			if(bottom)
				return hasPathCore(matrix2,str,rows,cols,rowsIndex,colsIndex+1,strIndex);
		}
		return false;
	}

	private static boolean Equal(char[][] matrix, char[] str, int rowsIndex, int colsIndex,int strIndex) {
		if(str[strIndex]==matrix[rowsIndex][colsIndex])
			return true;
		return false;
	}

	private static char[][] buildMatrix(char[] matrix, int rows, int cols) {
		char[][] matrix2 = new char[rows][cols];
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix2[i][j] = matrix[index];
				index++;
			}
		}
		return matrix2;
	}

}
