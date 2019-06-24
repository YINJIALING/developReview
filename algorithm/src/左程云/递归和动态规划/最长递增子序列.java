package 左程云.递归和动态规划;

public class 最长递增子序列 {

	public static void main(String[] args) {
		int[] arr=new int[] {2,1,5,3,6,4,8,9,7};
		int[] dp=getdp(arr);
		int[] lis=generateLIS(arr,dp);
		for(int i:lis){
			System.out.print(i+",");
		}
	}

	//根据最长子序列dp和原数组生成最长子序列
	private static int[] generateLIS(int[] arr, int[] dp) {
		int len=0,index=0;//dp对应的值，dp的坐标
		for(int i=0;i<dp.length;++i) {
			if(dp[i]>len) {
				len=dp[i];
				index=i;
			}
		}
		//找到了最长子序列的长度len,和结束的坐标index
		int[] lis=new int[len];
		lis[--len]=arr[index];
		for(int i=index;i>=0;i--) {
			if(arr[i]<arr[index]&&dp[i]==dp[index]-1) {
				lis[--len]=arr[i];
				index=i;
			}
		}
		return lis;
	}

	/*
	 * dp[i]:以i结尾的数，arr[0---i]最大递增子序列的长度
	 * 
	 */
	private static int[] getdp(int[] arr) {
		int length=arr.length;
		int[] dp=new int[length];
		for(int i=0;i<length;++i) {
			dp[i]=1;// 初始值为1
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j])
					dp[i]=Math.max(dp[i],dp[j]+1);//如果是递增的
			}
		}
		return dp;
	}

}
