package medium;

import java.util.LinkedHashMap;
/**
 * http://www.cnblogs.com/DarrenChan/p/8744354.html
 * @author yinjialing
 *
 */
public class LRU缓存机制 {
	LinkedHashMap<Integer,Integer> map;
	int capacity;
	public LRU缓存机制(int capacity) {
		this.capacity = capacity;
		map=new LinkedHashMap<>();
	}
	public int get(int key) {
		if(map.containsKey(key)) {
			int value=map.get(key);
			map.remove(key);//先删去
			map.put(key, value);//再增加进去，确保在第一位
			return value;
		}
			
		return -1;
	}
	
	public void put(int key, int value) {
		if(map.containsKey(key))
			map.remove(key);
		if(map.size()>=capacity)//删去第一个有效节点，因为第一个是最近最少使用节点
			map.remove(map.keySet().iterator().next());
		map.put(key, value);
	}
}
