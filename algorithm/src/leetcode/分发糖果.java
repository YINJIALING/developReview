package leetcode;

public class 分发糖果 {

	public static void main(String[] args) {
		System.out.println(candy(new int[] {1,2,2}));
	}

	public static int candy(int[] ratings) {
		int count=0,i=0,n=ratings.length;
		int[] candy=new int[ratings.length];
		i=1;
		
		//先从左向右，如果当前位上的数大于之前一位的，则在之前那位上加1
		while(i<n) {
			if(ratings[i]>ratings[i-1])
				candy[i]=candy[i-1]+1;
			i++;
		}
		
		//再从右往左，如果当前位上的数大于之前一位的且candy中没任何表示的，则在那位上加1 
		i=n-1;
		while(i!=0) {
			if(ratings[i]<ratings[i-1]&&candy[i]>=candy[i-1]) {
				candy[i-1]=candy[i]+1;
			}
			i--;
			
		}
		
		for(int index:candy)
			count+=index;
		return count+n;//因为每位学生至少有一个糖果
	}

}
