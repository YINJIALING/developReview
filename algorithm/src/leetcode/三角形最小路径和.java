package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * https://blog.csdn.net/seagal890/article/details/79436040
 * @author yinjialing
 *
 */
public class 三角形最小路径和 {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(2);
		System.out.println(getMinOfList(list));
	}
	
public int minimumTotal(List<List<Integer>> triangle) {
	int[][] dp=new int[triangle.size()][triangle.size()];
       // int min=triangle.get(0).get(0);
	dp[0][0]=triangle.get(0).get(0);
//	for(int i=1;i<triangle.size();i++) {
//		dp[0][i]=0;
//	}
	for(int i=1;i<triangle.size();i++) {
		dp[0][i]=0;
	}
	for(int i=1;i<triangle.size();i++) {
		dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
	}
	for(int i=1;i<triangle.size();i++) {
        for(int j=1;j<triangle.get(i).size();j++) {
        	dp[i][j]=triangle.get(i).get(j)+Math.min(triangle.get(i-1).get(j-1)
        			, triangle.get(i-1).get(j));
        }
        }
        
        return dp[triangle.size()-1][triangle.size()-1];

}
//private static Map<String,Integer> getMinOfNumber()
private static int getMinOfList(List<Integer> list) {
	int min=list.get(0);
	for(Integer index:list) {
		if(min>index)
			min=index;
	}
	return min;
}

}
