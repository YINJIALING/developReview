package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 游戏 {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int n=Integer.parseInt(in.nextLine());
		 String[] numsStr=in.nextLine().toString().split(" ");
		 List<Integer> list=new ArrayList<>();
		 List<Boolean> listfihao=new ArrayList<>();
		 for(int i=0;i<list.size();i++) {
			 int tmp=Integer.parseInt(numsStr[i]);
			 list.add(tmp);
			 if(tmp>=0)listfihao.add(true);
			 else listfihao.add(false);		 
		 }
	
		 System.out.println(test(list,n,listfihao));
	}
	public static int test(List<Integer> list,int n,List<Boolean> listfihao) {
		if(n==1)return list.get(0);
			return 0;
		
	}

}
