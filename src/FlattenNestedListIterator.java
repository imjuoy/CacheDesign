
/**
 * Nested Integer is a class that has a separate implementation not available for now.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {

	Iterator<Integer> it;

	public FlattenNestedListIterator(List<NestedInteger> list) {
		// TODO Auto-generated constructor stub
		List<Integer> result = new ArrayList<Integer>();
		if (list != null) {
			flatten(list, result);
		}

		it = result.iterator();

	}

	public void flatten(List<NestedInteger> list, List<Integer> nums) {
		for (NestedInteger n : list) {
			if (n.isInteger())
				nums.add(n.getInteger());
			else
				flatten(n.getList(), nums);
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return it.hasNext();
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return it.next();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
