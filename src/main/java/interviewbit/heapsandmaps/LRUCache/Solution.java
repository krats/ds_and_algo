package interviewbit.heapsandmaps.LRUCache;

import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
	private TreeMap<Integer, Pair> lru;
	private int id;
	private HashMap<Integer, Integer> cache;
	private int capacity;
	public Solution(int capacity) {
		this.capacity = capacity;
		lru = new TreeMap<>();
		id=0;
		cache = new HashMap<>();
	}
	
	public int get(int key) {
		if(cache.containsKey(key))
		{
			int current = cache.get(key);
			Pair value = lru.get(current);
			lru.remove(current);
			lru.put(id, value);
			cache.put(key, id);
			id++;
			return value.b;
		}
		return -1;
	}
	
	public void set(int key, int value) {
		if(cache.containsKey(key))
		{
			int current = cache.get(key);
			lru.remove(current);
			cache.remove(key);
		}
		lru.put(id, new Pair(key, value));
		cache.put(key, id);
		id++;
		if(cache.size() > capacity)
		{
			int first = lru.firstKey();
			Pair c = lru.get(first);
			lru.remove(first);
			cache.remove(c.a);
		}
	}
	
	class Pair {
		int a,b;
		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}
}
