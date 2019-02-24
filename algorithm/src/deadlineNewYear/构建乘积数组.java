package deadlineNewYear;

public class 构建乘积数组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] array= {1,2,3,4,5};
		 int[] res=multiply(array);
		 for(int index:res)
			 System.out.print(index+" ");
	}
	public static int[] multiply(int[] A) {
		if(A==null||A.length==0)
			return null;
		int[] res=new int[A.length];	
		for(int i=0;i<res.length;i++) {
			res[i]=1;
			for(int j=0;j<res.length;j++) {
				if(i!=j)
					res[i]*=A[j];
			}
			
		}
		return res;
    }

}
