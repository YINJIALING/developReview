package 剑指offer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo1 {

	
	    public static void main(String[] args)
	    {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int method = comb(n+k-1,n);
	        System.out.println(method);
	    }

	    public static int comb(int m, int n)
	    {
	        String temp = "";
	        if(n==0)
	            return 1;
	        if (n==1) 
	        {
	        	for(int i=0; i<m; i++)
	            {
	               temp+="*";
	            }
	            temp+="|";
	            System.out.println(temp);
	            return m;
	        }
	            
	        if(n>m/2)
	            return comb(m,m-n);
	        if(n>1)
	            return comb(m-1,n-1)+comb(m-1,n);
	        return -1;
	    
	}
}
