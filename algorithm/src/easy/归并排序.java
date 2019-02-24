package easy;

import java.util.Arrays;

/**
 * 时间复杂度O(nlogn)，空间复杂度O(n)
 * @author yinjialing
 *
 */
public class 归并排序 {
	
	private static final int TEST_TIME=50000;
	
	private static final int MAX_SIZE=100;
	
	private static final int MAX_VALUE=100;

	public static void main(String[] args) {
		boolean succeed=true;
		for(int i=0;i<TEST_TIME;i++) {
			int[] arr1=generateRandomArray(MAX_SIZE,MAX_VALUE);
			int[] arr2=arr1.clone();
			sort(arr1);
			comparator(arr2);
			if(!isEqual(arr1,arr2)) {
				succeed=false;
				print(arr1);
				print(arr2);
				break;
			}
		}
		System.out.println(succeed?"Nice":"error");
//		int[] array={6,18,3,5,6};
//		sort(array);
//		for(int index:array) {
//			System.out.print(index+" ");
//		}
	}
	
	public static void sort(int[] arr) {
		int[] temp=new int[arr.length];//临时数组
		sort(arr,0,arr.length-1,temp);
	}

	private static void sort(int[] arr, int left, int right, int[] temp) {
		if(left<right) {
			int mid=(left+right)>>1;
			sort(arr,left,mid,temp);//使左子序列有序
			sort(arr,mid+1,right,temp);//使右子序列有序
			merge(arr,left,mid,right,temp);//将两个有序的子序列合并
		}
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int t=0;//temp数组指针
		int i=left;//左序列指针
		int j=mid+1;//右序列指针
		while(i<=mid&&j<=right) {
			temp[t++]=(arr[i]<=arr[j])?arr[i++]:arr[j++];
		}
		
		while(i<=mid) {
			temp[t++]=arr[i++];//将左边剩余元素填充进temp
		}
		while(j<=right) {
			temp[t++]=arr[j++];
		}
		t=0;
		//将temp中的元素拷贝到原数组中
		while(left<=right) {
			arr[left++]=temp[t++];
		}
	}
	
//使用对数器测试
	//1. 先生成随机数数组
	private static int[] generateRandomArray(int maxSize,int maxValue) {
		int[] arr=new int[(int) ((maxSize+1)*Math.random())];//Math.random()范围[0,1)
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int) ((maxSize+1)*Math.random()-maxSize*Math.random());
		}
		return arr;
	}

	//2.写个clone的方法
	//3.写个完全正确的方法--这里调的是是java类库的排序
	private static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	//4.将两个结果判断是否相等
	private static boolean isEqual(int[] arr1,int[] arr2) {
		if(arr1==null&&arr2==null)
			return true;
		if(arr1==null||arr2==null)
			return false;
		if (arr1.length!=arr2.length)
			return false;
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}
	
	private static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
