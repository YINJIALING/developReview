package 剑指offer2;

public class 剪绳子 extends 二维数组中的查找 {

	public static void main(String[] args) {
		System.out.println(maxProductAfterCutting2(8));

	}
	/**
	 * 动归
	 * 对于长度为n绳子的来说，剪一次分别为i和n-i。最大乘积是max(f(i)*f(n-i))
	 * @param length
	 * @return
	 */
	public static int maxProductAfterCutting(int length) {
		if(length<2)return 0;
		if(length==2)return 1;
		if(length==3)return 2;//答案在这里返回
		int[] products=new int[length+1];
		products[0]=0;products[1]=1;products[2]=2;products[3]=3;
		//初始化,当绳子被剪为1和n-1,前一部分的最大长度是1；当绳子被剪为2和n-2, 前一部分的最大长度是2；当绳子被剪为3和n-3, 前一部分的最大长度是3(非答案)
		for(int i=4;i<=length;i++) {//从绳子的长度大于等于4时，开始运用递推式计算
			int max=Integer.MIN_VALUE;
			for(int j=1;j<=i/2;j++) {
				max=max>(products[j]*products[i-j])?max:(products[j]*products[i-j]);
				products[i]=max;
			}
			
		}
		return products[length];
	}

	/**
	 * 贪心
	 * 当n>=5,尽可能剪长度为3的绳子
	 * 当n=4,剪成两个长度为2的绳子
	 * @param length
	 * @return
	 */
	public static int maxProductAfterCutting2(int length) {
		if(length<2)return 0;
		if(length==2)return 1;
		if(length==3)return 2;//答案在这里返回
		
		int timeOf3=length/3;
		if(length-timeOf3*3==1) {
			//处理length=4的时候
			timeOf3-=1;
		}
		//尽可能的每次剪2
		int timeOf2=(length-timeOf3*3)/2;
		return (int) (Math.pow(3,timeOf3)*Math.pow(2,timeOf2));
	}
}
