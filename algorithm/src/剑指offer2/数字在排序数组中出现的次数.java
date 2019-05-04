package 剑指offer2;

public class 数字在排序数组中出现的次数 {

	public static void main(String[] args) {
		System.out.println(GetNumberOfK(new int[] {3,3,3,3,4,5},3));

	}
	public static int GetNumberOfK(int [] array , int k) {
		int number=0;
		if(array!=null&&array.length!=0) {
			 int first=getFirstK(array,array.length,k,0,array.length-1);
		     int last=getLastK(array,array.length,k,0,array.length-1);
		     if(last!=-1&&first!=-1)
		    	 	number=last-first+1;
		}
		return number;
    }
	// 计算k的最后一个索引处
	private static int getLastK(int[] array, int length, int k, int start, int end) {
		if(start>end)return -1;
		int middleIndex=(start+end)/2;
		int middleData=array[middleIndex];
		if(middleData>k)
			end=middleIndex-1;
		else if(middleData<k)
			start=middleIndex+1;
		else {
			//如果middleIndex是最后一个等于k的或middleIndex等于数组的长度
			if(middleIndex<length-1&&array[middleIndex+1]>k||middleIndex==length-1)
				return middleIndex;
			else
				start=middleIndex+1;
		}
		return getLastK(array,array.length,k,start,end);
	}
	// 计算k的第一个索引处
	private static int getFirstK(int[] array, int length, int k, int start, int end) {
		if(start>end)return -1;
		int middleIndex=(start+end)/2;
		int middleData=array[middleIndex];
		if(middleData>k) {
			end=middleIndex-1;
		}else if(middleData<k) {
			start=middleIndex+1;
		}else {
			//如果middleIndex是第一个等于k的或middleIndex等于start
			if(middleIndex>0&&array[middleIndex-1]<k||middleIndex==0)
				return middleIndex;
			else
				end=middleIndex-1;
		}
		return getFirstK(array,length,k,start,end);
	}

}
