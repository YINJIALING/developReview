package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {

	public static void main(String[] args) {
		int[] nums= {2,3,6,7};
		System.out.println(combinationSum(nums,7));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        int p1=0,p2=0,n=candidates.length;
        int sum=0;
        while(p1<n) {
        	List<Integer> tmp=new ArrayList<>();
        	tmp.add(candidates[p1]);
        	sum+=candidates[p1];
        	if(sum==target) {
        		if(!res.contains(tmp))
        			res.add(tmp);
        		break;
        	}
        	p2=p1;
        	System.out.println(p2);
        		while(sum<target&&p2<n) {
        			sum+=candidates[p2];
        			tmp.add(candidates[p2]);
        			System.out.println(tmp.toString()+" "+p1+" "+p2);
        			if(sum==target) {
        				res.add(tmp);
        				sum=0;
        				break;		
        			}
        			else if(sum>target) {
        				sum=sum-candidates[p2];
        				tmp.remove(tmp.size()-1);
        				p2++;
        				if(p2==n) {
        					sum=sum-tmp.remove(tmp.size()-1);;
        					p2=p1+1;
        				}
        				//break;
        			}
        		}
        		p1++;
        		
        }
        return res;
    }

}
