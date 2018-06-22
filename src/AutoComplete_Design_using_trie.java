import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 */

/**
 * @author subhadeepbhattacharyya
 *
 */
public class AutoComplete_Design_using_trie {

	/**
	 * @param args
	 */

	TrieNode root;
	String prefix;

	// Parameterized constructor
	public AutoComplete_Design_using_trie(String[] sentences, int[] times) {
		root = new TrieNode();
		prefix = "";
		for (int index = 0; index < sentences.length; index++)
			add(sentences[index], times[index]);// calling the add function to add the sentence the number of times it
												// has been searched.

	}

	public void add(String sentence, int time) {
		TrieNode node = root;
		for (char c : sentence.toCharArray()) {
			TrieNode current = node.children.get(c); // Remeber we used to have an array of nodes // hashmap of nodes
			if (current == null) {
				current = new TrieNode();
				node.children.put(c, current);// Put the character and the TrieNode under the root
			}
			node = current;
			// The below block adds the sentence and the number of times it has been
			// searched to the count hashmap
			if (!node.count.containsKey(sentence))
				node.count.put(sentence, time);
			else
				node.count.put(sentence, node.count.get(sentence) + time);
		}
		node.isWord = true;
	}

	public List<String> input(char c) {
		if (c == '#') {
			add(prefix, 1);
			// resetting prefix
			prefix = "";
			// returning a null arrayList since this character does not have a match with
			// the existing sentences
			return new ArrayList<String>();
		}

		prefix += c; // concatinating the searched characters
		TrieNode current = root;
		for (char cc : prefix.toCharArray()) {
			TrieNode next = current.children.get(cc);
			if (next == null)
				return new ArrayList<String>();
			current = next;
		}

		/*
		 * This statement is basically used to sort the answers by: 1. if the value i.e
		 * the number of the sentences have been searched is equal, then return the
		 * sentence which is lexicographically first. 2. Otherwise if the values are
		 * different return the sentences that have highest searched value. Hence
		 * "b - a"
		 */
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,
				b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
		pq.addAll(current.count.entrySet());

		List<String> result = new ArrayList<>();

		int k = 3;
		while (!pq.isEmpty() && k > 0) {
			result.add((String) pq.poll().getKey());
			k--;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sentences = { "i love you", "island", "ironman", "i love leetcode" };
		int[] times = { 5, 3, 2, 2 };
		AutoComplete_Design_using_trie obj = new AutoComplete_Design_using_trie(sentences, times);
		System.out.println(obj.input('i').toString());
		System.out.println(obj.input(' ').toString());
		System.out.println(obj.input('a').toString());
		System.out.println(obj.input('#').toString());

	}

}

class TrieNode {
	Map<Character, TrieNode> children;// Keeps a track of all the characters and a trieNode for them
	Map<String, Integer> count;// Keeps a track of sentences and the number of times they have been searched
	boolean isWord; // marks the end of the word

	public TrieNode() {
		children = new HashMap<>();
		count = new HashMap<>();
		isWord = false;
	}

}
