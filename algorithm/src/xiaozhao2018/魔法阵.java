package xiaozhao2018;

import java.util.Scanner;

public class 魔法阵 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int count=0;
		String[] str=new String[n*2];
		in.nextLine();
		while(count<n*2) {
			str[count]=in.nextLine();
			count++;
		}
		for(int i=0;i<str.length;i=i+2) {
			System.out.println(test(str[i],str[i+1]));
		}

	}

	/**
	 * 根据坐标判断是否是正方形
	 * 1.先根据三个点，判断是否有两条边是相等，if没有，return no;否则继续下一步
	 * 2.计算另外一个点和不是顶点的点距离是否相等，以及两边平方的和=第三条边的平方，if都满足，return yes
	 * @param string
	 * @param string2
	 * @return
	 */
	private static String test(String string1, String string2) {
		char[] c1=string1.toCharArray();
		char[] c2=string2.toCharArray();
		int[] nums1=parseCharArr(c1);
		int[] nums2=parseCharArr(c2);
		int l1=juli(nums1[0],nums2[0],nums1[1],nums2[1]);
		int l2=juli(nums1[1],nums2[1],nums1[2],nums2[2]);
		int l3=juli(nums1[0],nums2[0],nums1[2],nums2[2]);
		int l4=0,l5=0;
		if(!check(l1,l2,l3))
			return "No";
		if(l1==l2) {
			l4=juli(nums1[3],nums2[3],nums1[0],nums2[0]);
			l5=juli(nums1[3],nums2[3],nums1[2],nums2[2]);
			if(l4==l5&&l4+l5==l3)
				return "Yes";
			else
				return "No";
		}
		if(l1==l3) {
			l4=juli(nums1[3],nums2[3],nums1[2],nums2[2]);
			l5=juli(nums1[3],nums2[3],nums1[1],nums2[1]);
			if(l4==l5&&l4+l5==l2)
				return "Yes";
			else
				return "No";
		}
		
		if(l2==l3) {
			l4=juli(nums1[3],nums2[3],nums1[0],nums2[0]);
			l5=juli(nums1[3],nums2[3],nums1[1],nums2[1]);
			if(l4==l5&&l4+l5==l1)
				return "Yes";
			else
				return "No";
		}
		return "No";
	}

	private static boolean check(int l1, int l2, int l3) {
		if(l1==l2||l1==l3||l2==l3)return true;
		return false;
	}

	private static int[] parseCharArr(char[] c) {
		int[] num=new int[c.length];
		for(int i=0;i<num.length;i++) {
			num[i]=Integer.parseInt(c[i]+"");
		}
		return num;
	}
	
	private int change(char c) {
		return Integer.parseInt(c+"");
	}
	/**
	 * 计算两点之间的距离
	 * @param c 第一个点的横坐标
	 * @param d 第1个点的纵坐标 
	 * @param e 第2个点的横坐标
	 * @param f 第2个点的纵坐标
	 * @return
	 */
	private static int juli(int c, int d, int e, int f) {
		return (int) (Math.pow((c-e), 2)+Math.pow((d-f), 2));
		
	}

}
