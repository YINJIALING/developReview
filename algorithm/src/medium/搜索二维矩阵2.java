package medium;

public class 搜索二维矩阵2 {

	public static void main(String[] args) {
		System.out.println(searchMatrix(
				new int[][]{{1,4,7,11,15},{2,5,8,12,19}},5));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0)return false;
		int n=matrix.length-1;
		int m=matrix[0].length-1;
		while(m>=0&&n>=0)
		{
			if(matrix[n][m]==target) {
				return true;
			}else if(matrix[n][m]<target) {
				return false;
			}else {
				for(int i=0;i<=m;i++) {
					if(matrix[n][i]==target)
						return true;
				}
				for(int i=0;i<=n;i++) {
					if(matrix[i][m]==target)
						return true;
				}
				m--;
				n--;
			}
		}	
		return false;
	}

}
