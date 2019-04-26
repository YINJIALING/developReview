package 剑指offer2;

public class 二维数组中的查找 {

	public static void main(String[] args) {
	
		System.out.println(Find(7,new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));

	}
	/**
	 * 将右上角的数与target比较
	 * 1.=,找到
	 * 2.>将范围缩小至左边
	 * 3.<将范围扩大至右边
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean Find(int target, int [][] array) {
		if(array==null)return false;
		int rows=array.length,row=0,column=array[0].length-1;
		while(row<rows&&column>=0) {
			if(array[row][column]==target)return true;
			else if(array[row][column]>target) {
				--column;
			}else {
				++row;
			}
		}
		return false;
    }

}
