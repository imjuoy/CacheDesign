import java.util.LinkedHashMap;

public class LRUCache_LinkedHashMap {

	private LinkedHashMap<Integer, Integer> cache;
	private int capacity;

	public LRUCache_LinkedHashMap(int capacity) {
		this.cache = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer value = cache.get(key);
		if (value != null) {
			int result = value;
			cache.remove(key);
			cache.put(key, value);
			return result;
		}
		return -1;
	}

	public void put(int key, int val) {
		Integer value = cache.get(key);
		if (value != null) {
			cache.remove(key);
			cache.put(key, val);
		} else if (cache.size() == capacity)
			cache.remove(cache.entrySet().iterator().next().getKey());
		cache.put(key, val);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRUCache_LinkedHashMap cache = new LRUCache_LinkedHashMap(2);
		cache.put(1, 1);
		cache.put(2, 2);
		// cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
	}

}
