package deadlineNewYear;

public class 不修改数组找出重复的数字 {

	public static void main(String[] args) {
		int[] arr= {2,3,1,0,2,5,3};
		System.out.println(process1(arr));
	}

	// 建立辅助数组，复制
	private static int process1(int[] arr) {
		if(arr==null||arr.length==0||arr.length==1)
			return -1;
		int temp[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(temp[arr[i]]!=arr[i]||arr[i]==0) {
				temp[arr[i]]=arr[i];
			}else {
				return arr[i];
			}
				
		}
		return -1;
	}
	
	private static void print(int[] arr) {
		for(int index:arr) {
			System.out.print(index+"\t");
		}
		System.out.println();
	}
}
