import java.util.HashMap;

public class TwoSumDataStructure {

	HashMap<Integer, Integer> map;
	int maxVal, minVal;

	public TwoSumDataStructure() {
		map = new HashMap<>();
		minVal = Integer.MAX_VALUE;
		maxVal = Integer.MIN_VALUE;
	}

	public void add(int val) {
		minVal = Math.min(minVal, val);
		maxVal = Math.max(maxVal, val);
		if (!map.containsKey(val))
			map.put(val, 1);
		else
			map.put(val, map.get(val) + 1);
	}

	public boolean isPresent(int target) {
		if (target < minVal * 2 || target > maxVal * 2)
			return false;
		for (Integer n : map.keySet()) {
			int complement = target - n;
			if ((complement == target && map.get(complement) > 1)
					|| (complement != target && map.containsKey(complement)))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumDataStructure obj = new TwoSumDataStructure();
		obj.add(3);
		obj.add(3);
		obj.add(3);
		System.out.println(obj.isPresent(9));
	}

}
