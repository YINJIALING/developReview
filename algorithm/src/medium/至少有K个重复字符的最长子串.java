
package medium;

/*
 * https://ask.julyedu.com/question/85351
 */
public class 至少有K个重复字符的最长子串 {

	public static void main(String[] args) {
		System.out.println(longestSubstring("aaabb",3));
	}

	public static int longestSubstring(String s, int k) {
		if(s.length()==1&&k==1)return 1;
		char[] arr=s.toCharArray();
		int size=0;
		for(int i=0;i<arr.length;i++) {//左指针
			int[] mip=new int[26];//由小写字母组成
			mip[arr[i]-'a']++;//记录每个小写字母的出现次数
			for(int j=i+1;j<arr.length;j++) {//滑动窗口法，右指针
				mip[arr[j]-'a']++;
				if(arrBiggerK(mip,k)==true&&j-i+1>size) {//前者判断这个字段是否满足其中当前有的字段个数都>k，后者判断当前长度是否大于之前的最长长度size
					size=j-i+1;//更新size
				}
			}
		}
		return size;
		
	}

	//判断这个字段是否满足当前有的字段个数都>k
	private static boolean arrBiggerK(int[] mip, int k) {
		for(int c :mip) {
			if(c>0&&c<k)
				return false;
		}
		return true;
	}

}
