package leetcode;

public class 旋转图像 {

	public static void main(String[] args) {
		int[][] test=new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] res=rotate(test);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				System.out.print(res[i][j]+",");
			}
			System.out.println();
		}
	}

	/*
	 * len=3
	 * a[0][0]-->a[0][len-1]
	 * a[len-1][0]-->a[0][0]
	 * a[len-1][len-1]-->a[len-1][0]
	 * a[0][len-1]-->a[len-1][len-1]
	 * 
	 * a[0][1]-->a[1][0]
	 * 中间的不变
	 * a[1][0]-->a[0][1]
	 */
	public static int[][] rotate(int[][] matrix) {
		int len=matrix.length;
		int[][] clone=new int[len][len];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(j==0) {
					clone[0][len-1-i]=matrix[i][j];
				}else if(i==len-1) {
					clone[j][0]=matrix[i][j];
				}else if(i==0) {
					clone[j][len-1]=matrix[i][j];
				}else if(j==len-1) {
					clone[j][len-1-i]=matrix[i][j];
				}else {
					if(len%2!=0&&i==j&&i==len/2) {
						clone[i][j]=matrix[i][j];
					}else
						clone[i][len-1-j]=matrix[i][j];
				}
			}
		}
		return clone;
	}

}
