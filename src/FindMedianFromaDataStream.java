import java.util.PriorityQueue;

/**
 * 
 * @author subhadeepbhattacharyya
 *
 * LeetCode Hard:
 * 
 * Given a stream of data calculate the median of the elements.
 * 
 * [1,2] Median 1.5
 * [1,2,3] Median 2
 * This can be solved using Heap ( a max heap to keep track of all the smaller element in the stream and
 * a min heap to keep track of all the large elements in the stream.
 * If the sizes of the heaps are equal then we add them up and divide by 2 
 * else we return the top the larger queue.
 */

/**
 * 
 * @author subhadeepbhattacharyya S
 */

public class FindMedianFromaDataStream {

	PriorityQueue<Long> large = new PriorityQueue<>();
	PriorityQueue<Long> small = new PriorityQueue<>();

	public void add(int val) {
		large.add((long) val);
		small.add(-large.poll());
		if (small.size() > large.size())
			large.add(-small.poll());
	}

	public double median() {
		if (large.size() == small.size())
			return (double) (large.peek() - small.peek()) / 2;
		else if (large.size() > small.size())
			return (double) large.peek();
		else
			return (double) small.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedianFromaDataStream obj = new FindMedianFromaDataStream();
		obj.add(2);
		obj.add(3);
		obj.add(4);
		System.out.println(obj.median());

	}

}
