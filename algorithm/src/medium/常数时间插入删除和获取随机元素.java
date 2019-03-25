package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class 常数时间插入删除和获取随机元素 {
	Map<Integer,Integer> map=null;//k:元素，v:出现在list中的位置
	List<Integer> list=null;
	int maxSize=0;

	 public 常数时间插入删除和获取随机元素() {
		 map=new HashMap<>();
		 list=new ArrayList<>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	    	if(map.containsKey(val))
	    		return false;
	    	else {
	    	 	map.put(val,maxSize);
		    	list.add(val);
		    	maxSize++;
			return true;
	    	}
	   
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if(map.containsKey(val)) {
	    		int oldIndex=map.get(val);//得到要删除的数在list中的位置
	    		int lastval=list.get(maxSize-1);//得到最后一个数值
	    		list.set(oldIndex, lastval);//将删除的数替换为lastval
	    		list.remove(maxSize-1);//删去最后一个数
	    		map.put(lastval, oldIndex);//更新lastval中的对应位置
	    		map.remove(val);
	    		maxSize--;
	    		return true;
	    	}else
	    		return false;
	    
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
			return list.get(new Random().nextInt(maxSize));
	        
	    }

}
