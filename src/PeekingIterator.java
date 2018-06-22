import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> iterator;
	Integer cache = null;

	public PeekingIterator(Iterator<Integer> it) {
		this.iterator = it;
		cache = iterator.next();
	}

	public Integer peek() {
		return cache;
	}

	@Override
	public Integer next() {
		int result = cache;
		if (iterator.hasNext())
			cache = iterator.next();
		else
			cache = null;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return cache != null;
	}

}
