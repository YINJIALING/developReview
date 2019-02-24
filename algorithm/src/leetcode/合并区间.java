package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 没做完
 * @author yinjialing
 *
 */
public class 合并区间 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Interval interval1=new Interval(1,3);
		Interval interval2=new Interval(2,6);
		List<Interval> origin=new ArrayList<>();
		origin.add(interval1);
		origin.add(interval2);
		List<Interval> res=merge(origin);
		print(res);
		
	}
	private static void print(List<Interval> res) {
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i).start+" "+res.get(i).end);
		}
	}
	
public static List<Interval> merge(List<Interval> intervals) {
	List<Interval> res=new ArrayList<>();
	
	res.add(intervals.get(0));
	for(int i=1;i<intervals.size();i++) {
		int start=intervals.get(i).start;
		int end=intervals.get(i).end;
		for(int j=0;j<res.size();j++) {
			if(res.get(j).start<=start&&end<=res.get(j).end&&start<res.get(j).end) {
				res.set(j, new Interval(start,end));
			}else if(res.get(j).start<=start&&end>res.get(j).end) {
				res.set(j, new Interval(start,res.get(j).end));
			}else if(end<=res.get(j).end&&res.get(j).start>start) {
				res.set(j, new Interval(res.get(j).start,end));
			}else {
				res.add(intervals.get(i));
			}
		}
	}
	return res;       
    }

}
class Interval {   
	int start;
    int end;
   Interval() { start = 0; end = 0; }
   Interval(int s, int e) { start = s; end = e; }
}
