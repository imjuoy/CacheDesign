
/**
 * 
 * Flatten a 2D- vector.
 * Beautiful solution.
 * 
 * [[1,2,3],
 * [4,5],
 * [6,7,8]]
 */

import java.util.Iterator;
import java.util.List;

public class Flatten2Dvector implements Iterator<Integer> {

	// We have two iterators namely the outerIterator to iterate throug the outer
	// listlist and
	// the innerIterator to iterate through the inner integers in each list
	Iterator<List<Integer>> outIterator; // OuterIterator
	Iterator<Integer> innerIterator;// Inner Number iterator

	public Flatten2Dvector(List<List<Integer>> vector) {
		outIterator = vector.iterator();// assigning the 2D vector to the iterator
		if (outIterator.hasNext())// checking if the 2D vector has a list, then assign the first inner list for
									// the inner vector
			innerIterator = outIterator.next().iterator();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This block is very crucial.
	/*
	 * The if's need to be in order. First we will check if the innerIterator is
	 * null or not. This is to avoid failures if the list is []. Next we need to
	 * check if the innerIterator has elements Next we will check if the outerList
	 * has any more innerList or not. THe order of checks matter for traversing the
	 * last list
	 * 
	 * Now once the first list has been traversed, all the if conditions will fail
	 * and the control goes to the line where we point the innerIterator to the next
	 * list. Now we need to check if the next list contains any element so the first
	 * condition in the while loop !innerIterator.hasNext() and the second condition
	 * checks if the outerlist has any other list. This means that if the current
	 * list has no elements and the outerlist has more lists then please point the
	 * inner pointer to the next list. Finally return innerPointer.has Next()
	 */

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (innerIterator == null)
			return false;
		if (innerIterator.hasNext())
			return true;
		if (!outIterator.hasNext())
			return false;
		innerIterator = outIterator.next().iterator();
		while (!innerIterator.hasNext() && outIterator.hasNext())
			innerIterator = outIterator.next().iterator();
		return innerIterator.hasNext();

	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return innerIterator.next();
	}

}
