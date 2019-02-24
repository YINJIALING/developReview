package deadlineNewYear;

public class 丑数 {

	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(10));
		System.out.println(GetUglyNumber_Solution2(10));
		System.out.println(GetUglyNumber_Solution3(10));
	}

	/**
	 * 超时
	 * @param index
	 * @return
	 */
	public static int GetUglyNumber_Solution(int index) {
		if(index<1)
			return 0;
		if(index==1)
			return 1;
		int[] array=new int[index+1];
		int count=2;
		array[0]=0;
		array[1]=1;
		for(int i=2;i<=index;i++) {
			while(!isUgly(count)) {
				count++;
			}
			array[i]=count;	
			count++;
		}
		//存放丑数
        return array[index];
    }
	
	/**
	 * 传入一个数判断是否是丑数
	 * @param index
	 * @return
	 */
	private static boolean isUgly(int index) {
		while(index%2==0)
			index/=2;
		while(index%3==0)
			index/=3;
		while(index%5==0)
			index/=5;
		return index==1?true:false;
	}
	/**
	 * 解法二：丑数的定义 index=2^x*3^y*5^z
	 */
	public static int GetUglyNumber_Solution2(int index) {
		if(index<1)
			return 0;
		if(index==1)
			return 1;
		int[] array=new int[index];
		array[0]=1;
		int nextUglyIndex=1;//指针从i=1开始
		int x=0,y=0,z=0;
		while(nextUglyIndex <index) {
			int min=getMinOfThree(array[x]*2,array[y]*3,array[z]*5);
			//nextUglyIndex++;
			array[nextUglyIndex]=min;
			nextUglyIndex++;
			if(array[x]*2==min)		
				x++;
			if(array[y]*3==min)		
				y++;
			if(array[z]*5==min)		
				z++;
		}
		return array[index-1];
	}

	private static int getMinOfThree(int i, int j, int k) {
		int min=i<j?i:j;
		return min<k?min:k;
	}
	
	private static int GetUglyNumber_Solution3(int n){
		if(n<=0)return 0;
		int[] arr=new int[n];
		arr[0]=1;
		int next=1;
		int x=0,y=0,z=0;
		while(next<n) {
			int min=getMinOfThree(arr[x]*2,arr[y]*3,arr[z]*5);
			arr[next]=min;
			next++;
			if(arr[x]*2==min)x++;
			if(arr[y]*3==min)y++;
			if(arr[z]*5==min)z++;
		}
		return arr[n-1];
	}
	
}
