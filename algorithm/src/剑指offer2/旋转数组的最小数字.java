package 剑指offer2;

public class 旋转数组的最小数字 {

	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[] {3,4,5,1,2}));

	}

	/**
	 * 初始化指针p1,p2,mid
	 * 如果array[p1]>=array[p2]进入循环
	 * 1.先判断array[mid]在前半部分递增还是在后半部分递增
	 * 如果array[mid]在前半部分递增，令p1=mid;反之，令p2=mid
	 * 
	 * 考虑一种情况array[mid]=array[p1]=array[p2],只能通过在p1,p2该范围内找最小的数
	 * 直到p2,p1的差值为1，说明找到最小值，返回array[p2]
	 * @param array
	 * @return
	 */
	public static int minNumberInRotateArray(int[] array) {
		int p1=0,p2=array.length-1,mid=p1;
		while(array[p1]>=array[p2]) {
			if(p2-p1==1) {
				mid=p2;
				break;
			}
			mid=(p1+p2)>>1;
			if(array[p1]==array[p2]&&array[p1]==array[mid])
				return minOrder(array,p1,p2);
			if(array[p1]<=array[mid])
				p1=mid;
			else
				p2=mid;
			
		}
		
		return array[mid];
	}

	//找出数组array，索引p1到p2之间最小的数 
	private static int minOrder(int[] array, int p1, int p2) {
		int min=Integer.MAX_VALUE;
		for(int i=p1;i<=p2;i++) {
			min=array[i]<min?array[i]:min;
		}
		return min;
	}

}
