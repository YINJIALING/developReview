package deadlineNewYear;

public class 数组中的逆序对 {
	public static void main(String[] args) {
		int[] array= {1,2,3,4,5,6,7,0};
		System.out.println(InversePairs(array));
	}
	
	/**
	 * 归并排序的思想
	 * 也是50%，考虑将int改为long
	 * @param array
	 * @return
	 */
	public static int InversePairs2(int[] array) {
		if(array==null||array.length==0||array.length==1)
			return 0;
		//辅助数组
		return count(array, 0, array.length-1);
			
	}
	private static int count(int[] A,int start,int end) {
		

			if (end <= start) {
			 
			   return 0;
			 
			  }
			 
			  int mid = (start + end) >> 1;//=(start+end)/2
			 
			  int count1 = count(A, start, mid);
			 
			  int count2 = count(A, mid + 1, end);
			 
			  return count1 + count2 + merge(A, start, mid, end);
	}

	private static int merge(int[] A, int start, int mid,int end) {
		int[] aux = new int[end - start + 1];
		 
		  int i = start;
		 
		  int j = mid + 1;
		 
		  int k = 0;
		 
		  int reverse = 0;
		 
		  while (i <= mid && j <= end) {
		 
		   if (A[i] <= A[j]) {
		 
		    aux[k++] = A[i++];
		 
		   } else {
		 
		    reverse += mid - i + 1;
		 
		    aux[k++] = A[j++];
		 
		   }
		 
		  }
		 
		 
		 
		  while (i <= mid) {
		 
		   aux[k++] = A[i++];
		 
		  }
		 
		  while (j <= end) {
		 
		   aux[k++] = A[j++];
		 
		  }
		 
		  for (int m = 0; m < aux.length; ++m) {
		 
		   A[start + m] = aux[m];
		 
		  }
		 
		  return reverse;
	}

	/**
	 * 超时，时间复杂度O(n^2)
	 * @param array
	 * @return
	 */
	public static int InversePairs(int[] array) {
		if(array==null||array.length==0||array.length==1)
			return 0;
		int count=0;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j])
					count++;
			}
			
		}
		return count;
	}
}
