import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author LeetCode
 * 
 *         Question: Design an auto-complete search engine. User's may input a
 *         sentence at least one word which ends with a # For each character
 *         typed except # return the top 3 hot sentences where the prefix
 *         matches the same part as the part typed.
 * 
 *         The hot degree for a sentence is defined as the number of times a
 *         user typed the exactly same sentence before. The returned top 3 hot
 *         sentences should be sorted by hot degree (The first is the hottest
 *         one). If several sentences have the same degree of hot, you need to
 *         use ASCII-code order (smaller one appears first). If less than 3 hot
 *         sentences exist, then just return as many as you can. When the input
 *         is a special character, it means the sentence ends, and in this case,
 *         you need to return an empty list.
 *
 */

public class AutoComplete_Design_using_HashMap {

	private Map<String, Integer> map = new HashMap<String, Integer>();// This is used to store the sentences and their
																		// frequency.
	private StringBuilder build = new StringBuilder();// The stringbuilder is used to create a string of characters that
														// have been typed by the user.

	private List<Map.Entry<String, Integer>> answers = new ArrayList<>(); // This is used to maintain a list of probable
																			// already searched words.

	public AutoComplete_Design_using_HashMap(String[] sentences, int[] times) {
		for (int idx = 0; idx < sentences.length; idx++)
			map.put(sentences[idx], times[idx]);// Map containing number of times a sentence has been searched
	}

	// This function will return the 3 hot results when char c is searched based on
	// the previously searched sentences with the same prefix.
	public List<String> input(char c) {
		List<String> ans = new ArrayList<>();
		if (c == '#') {// Marks completion of the search
			System.out.println(build.toString());
			if (!map.containsKey(build.toString()))
				map.put(build.toString(), 1);
			else
				map.put(build.toString(), map.get(build.toString()) + 1);
			build.setLength(0);// set the length of the stringbuilder to 0
			answers.clear();// clear the map list of ALL results
		} else {
			// Ongoing search
			build.append(c); // add the character to the existing string being searched
			if (build.length() == 1) // means this is the first searched letter
			{
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					if (entry.getKey().startsWith(build.toString()))
						answers.add(entry);
				}
				Collections.sort(answers, (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey())
						: b.getValue() - a.getValue());
			} else {
				// This is the else block when the user enters the second character in the
				// search
				/*
				 * the logic behind this block is:
				 */
				int size = answers.size();
				for (int i = size - 1; i >= 0; i--) {
					if (!answers.get(i).getKey().startsWith(build.toString()))
						answers.remove(i);
				}
			}
		}

		for (int i = 0; i < 3 && i < answers.size(); i++) {
			ans.add(answers.get(i).getKey());
		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sentences = { "i love you", "island", "ironman", "i love leetcode" };
		int[] times = { 5, 3, 2, 2 };

		AutoComplete_Design_using_HashMap obj = new AutoComplete_Design_using_HashMap(sentences, times);
		System.out.println(obj.input('i').toString());
		System.out.println(obj.input(' ').toString());
		System.out.println(obj.input('a').toString());
		System.out.println(obj.input('#').toString());
	}

}
