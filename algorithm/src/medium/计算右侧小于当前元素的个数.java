package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 计算右侧小于当前元素的个数 {

	public static void main(String[] args) {
//		print(countSmaller(new int[] {5,2,6,1}));
		print(countSmaller2(new int[] {5,2,6,1}));
		
	}

	private static void print(List<Integer> countSmaller) {
		for(Integer index:countSmaller)
			System.out.print(index+" ");
	}

	//暴力
	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> list=new ArrayList<>();
		if(nums.length==0)return list;
		int count;
		for(int i=0;i<nums.length-1;i++) {
			count=0;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]<nums[i])count++;
			}
			list.add(count);
		}
		list.add(0);
		return list;
	}
	
	//归并排序（分治）-- 计算逆序数
	public static List<Integer> countSmaller2(int[] nums) {
		int n=nums.length;
		int[] count=new int[n];
		List<Pair> pairs=new ArrayList<>();
		for(int i=0;i<n;i++) {
			pairs.add(new Pair(nums[i],i));
		}
		mergeSort(pairs,count);
		//当数组是基本数据类型时，不能使用Arrays.aslist(array)转成list
		List<Integer> res=new ArrayList<>();
		for(int index:count) {
			res.add(index);
		}
		return res;
	}

	private static void mergeSort(List<Pair> pairs,int[] count) {
		if(pairs.size()<2)
			return;
		
		int mid=pairs.size()/2;
		List<Pair> subPairs1=new ArrayList<>();
		List<Pair> subPairs2=new ArrayList<>();
		for(int i=0;i<mid;i++) {
			subPairs1.add(pairs.get(i));
		}
		for(int i=mid;i<pairs.size();i++) {
			subPairs2.add(pairs.get(i));
		}
		mergeSort(subPairs1,count);
		mergeSort(subPairs2,count);
		pairs.clear();
		mergeSortTwoVectors(subPairs1,subPairs2,pairs,count);
	}

	private static void mergeSortTwoVectors(List<Pair> subPairs1, List<Pair> subPairs2, List<Pair> pairs, int[] count) {
		int i=0,j=0;
		while(i<subPairs1.size()&&j<subPairs2.size()) {
			if(subPairs1.get(i).value<=subPairs2.get(j).value) {
				count[subPairs1.get(i).index]+=j;
				pairs.add(subPairs1.get(i));i++;
			}else{
				pairs.add(subPairs2.get(j));
				j++;
			}
		}
		while(i<subPairs1.size()) {
			count[subPairs1.get(i).index]+=j;
			pairs.add(subPairs1.get(i));i++;
		}
		while(j<subPairs2.size()) {
			pairs.add(subPairs2.get(j));j++;
		}
	}
	
}
class Pair{
	int value;
	int index;
	public Pair(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	
}

