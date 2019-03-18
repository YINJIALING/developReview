package bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 桌子腿 {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int n=in.nextInt();
		 int[] l=new int[n+1];
		 int[] d=new int[n+1];
		 for(int i = 0; i < n; i++){
			 l[i]=in.nextInt();
	        }
		 for(int i = 0; i < n; i++){
			 d[i]=in.nextInt();
	        }
		 System.out.println(test(l,d,n));
		 
	}

	private static int test(int[] l, int[] d, int n) {
		if(n==1)return 0;
		if(n==2) {
			if(l[0]>l[1])return d[0];
			else if(l[0]<l[1])return d[1];
			else return 0;
		}
		int count=0;
		Map<Integer,Integer> map=new HashMap<>();//索引，v: 出现的次数
		 
		if(n>2) {
			for(int i=0;i<l.length;i++) {
				map.put(i, map.getOrDefault(1, i)+1);
			}
			int tmpMax=0;//出现的最大次数
			for(Integer key:map.keySet()) {
				tmpMax=tmpMax<map.get(key)?map.get(key):tmpMax;
			}
			if(tmpMax>n/2)return 0;
			for(int i=0;i<d.length;i++) {
				if(map.get(i)==tmpMax)
					d[i]=Integer.MAX_VALUE;
			}
			int chazhi=(int) Math.ceil(n/2);
			int[] tmp=d.clone();
			Arrays.sort(tmp);
			for(int i=0;i<chazhi;i++) {
				count+=tmp[i];
			}
			
			return count;
		}
		return 0;
	}

}
