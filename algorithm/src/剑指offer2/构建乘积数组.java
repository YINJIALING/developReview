package 剑指offer2;

public class 构建乘积数组 {

	public static void main(String[] args) {
		int[] res=multiply(new int[] {2,3,4,5});
		for(int index:res)
			System.out.print(index+",");
	}

	public static int[] multiply(int[] A) {
		int length=A.length;
		int[] B=new int[length];
		B[0]=1;
		for(int i=1;i<length;i++) {
			B[i]=B[i-1]*A[i-1];
		}
		double temp=1;
		for(int i=length-2;i>=0;i--) {
			temp*=A[i+1];
			B[i]*=temp;
		}
		return B;
	}

}
