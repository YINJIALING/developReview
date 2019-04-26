package 剑指offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 矩阵中的路径 {
	public static void main(String[] args) {
		System.out.println(hasPath(new char[] {'a','b','c','e','s','f','c','s','a','d','e','e'}
		,3,4,new char[] {'a','b','c','b'}));
	}
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		char[][] array=new char[rows][cols];
		int index=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				array[i][j]=matrix[index++];
			}
		}
	
		int[][] mark=new int[rows][cols];
		boolean res=false;
		List<int[]> firstIndex=hasfirstIndex(str[0],array);
		if(firstIndex.isEmpty())return false;
		for(int[] tmp:firstIndex) {
			clear(mark);
			mark[tmp[0]][tmp[1]]=1;
			List resList=new ArrayList<>();
			hasPathCore(resList,array,mark,str,1,res,tmp[0],tmp[1]);
			if(!resList.isEmpty())return true;
		}
		return res;
    }
	//初始化一个二维数组，默认值为0
	private static void clear(int[][] mark) {
		for(int[] i:mark)
			Arrays.fill(i, 0);
		
	}
	
	//判断一个二维数组中的值是否包含字符c,如果包含，将i,j存入一个长度为2的数组，返回 list
	//因为可能存在多个等于c 
	private static List<int[]> hasfirstIndex(char c, char[][] array) {
		List<int[]> res=new ArrayList<>();
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				if(c==array[i][j]) {
					res.add(new int[] {i,j});
				}
			}
		}
		return res;
	}
	/*
	 * 设p1,p2是当前位置，通过isvalid函数，返回list，判断是否能走
	 * 1.如果list为空，说明，走不空，回溯至上一步
	 * 2.遍历list,根据当前值将mark相应的值置为1，进行下一次的递归
	 * mark用来标记是否进入该路径
	 */
	private static void hasPathCore(List resList,char[][] array, int[][] mark, char[] str, int i,boolean res,int p1,int p2) {
		if(i==str.length) {
			res=true;
			resList.add(1);
			return;
		}
		List<int[]> list=isvalid(mark,p1,p2,str[i],array);
		if(list.isEmpty())return;
		char c=str[i];
		for(int[] way:list) {
				mark[way[0]][way[1]]=1;
				hasPathCore(resList,array,mark,str,i+1,res,way[0],way[1]);//递归
		}
		
	}
	private static int[][] clonearrsy(int[][] mark) {
		int[][] res=new int[mark.length][mark[0].length];
		for(int i=0;i<mark.length;i++) {
			res[i]=mark[i].clone();
		}
		return res;
	}
	//判断mark[i][j]四个方向是否能走，如果能走，记录能走的坐标返回一个list
	private static List isvalid(int[][] mark,int i,int j,char c,char[][] array) {
		List<int[]> res=new ArrayList<>();
		if(i>=0&&j>=0&&i<mark.length&&j<mark[0].length) {
			if(i<mark.length-1&&mark[i+1][j]!=1&&array[i+1][j]==c)
				res.add(new int[] {i+1,j});
			if(i>0&&mark[i-1][j]!=1&&array[i-1][j]==c)
				res.add(new int[] {i-1,j});
			if(j<mark[0].length-1&&mark[i][j+1]!=1&&array[i][j+1]==c)
				res.add(new int[] {i,j+1});	
			if(j>0&&mark[i][j-1]!=1&&array[i][j-1]==c)
				res.add(new int[] {i,j-1});					
		}
		return res;
	}
}
