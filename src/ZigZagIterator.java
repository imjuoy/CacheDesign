import java.util.Iterator;
import java.util.List;

public class ZigZagIterator implements Iterator<Integer> {

	Iterator<Integer> i, j, tmp;

	public ZigZagIterator(List<Integer> l1, List<Integer> l2) {
		i = l1.iterator();
		j = l2.iterator();

	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return i.hasNext() || j.hasNext();
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		if (j.hasNext()) {
			tmp = j;
			j = i;
			i = tmp;
		}
		return j.next();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
