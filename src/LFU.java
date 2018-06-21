import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Least Frequently Used Cache
 * 
 * @author subhadeepbhattacharyya
 *
 */

public class LFU {

	HashMap<Integer, Integer> cache;
	List<Integer> innerList;
	int capacity;

	public LFU(int capacity) {
		this.cache = new LinkedHashMap<>();
		this.innerList = new ArrayList<>();
		this.capacity = capacity;
	}

	public void put(int key, int val) {
	}

	public int get(int key) {
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
