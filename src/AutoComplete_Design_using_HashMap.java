import java.util.ArrayList;
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

	private List<Map.Entry<String, Integer>> answers = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
