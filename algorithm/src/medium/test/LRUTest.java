package medium.test;

import medium.LRU缓存机制;

public class LRUTest {

	public static void main(String[] args) {
		LRU缓存机制 cache=new LRU缓存机制(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(1));
	}

}
