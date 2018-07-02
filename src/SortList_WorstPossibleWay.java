import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList_WorstPossibleWay {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode SortList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		ListNode curr = head;
		while (curr != null) {
			list.add(curr.val);
			curr = curr.next;
		}

		Collections.sort(list);
		ListNode node = new ListNode(0);
		ListNode newHead = node;
		for (Integer nums : list) {
			ListNode newNode = new ListNode(nums);
			newHead.next = newNode;
			newHead = newNode;
		}

		return node.next;

	}

	public static void main(String[] args) {
		// To-do add code for running the program.
		// accepted by Leetcode beats 3.79%.
	}

}
