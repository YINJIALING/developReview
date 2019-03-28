package medium;

import java.util.LinkedHashMap;
/**
 * http://www.cnblogs.com/DarrenChan/p/8744354.html
 * @author yinjialing
 *
 */
public class LRU缓存机制 {
	LinkedHashMap<Integer,Integer> map;
//	Map<Integer, Integer> map;
//	Map<Integer, Integer> countMap;
	int capacity;
//	Queue<Integer> heap;
	public LRU缓存机制(int capacity) {
		this.capacity = capacity;
		map=new LinkedHashMap<>();
	}
	public int get(int key) {
		if(map.containsKey(key)) {
			int value=map.get(key);
			map.remove(key);
			map.put(key, value);
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

//	public LRU缓存机制(int capacity) {
//		map = new HashMap<>();
//		countMap = new HashMap<>();
//		this.capacity = capacity;
//		heap = new PriorityQueue<>(capacity, new Comparator<Integer>() { // 最小优先队列
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return countMap.getOrDefault(o2,0).compareTo(countMap.getOrDefault(o1,0));
//			}
//
//		});
//	}

//	public int get(int key) {
//		if (map.containsKey(key)) {
//			countMap.put(key, countMap.getOrDefault(key, 0) + 1);
//			return map.get(key);
//		} else
//			return -1;
//	}

//	public void put(int key, int value) {
//		if (map.size() == capacity) {
//			int index = heap.poll();
//			map.remove(index);
//			countMap.remove(index);
//		}
//		if (!map.containsKey(key)) {
//			map.put(key, value);
//			heap.add(key);
//			countMap.put(key, 0);
//		}
//			
//	}
}
