import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a list of words such as 
 * List: ["w","wo","wor","word"]
 * Find the longest word that can be formed from the words.
 * There are two approaches to this question:
 * 1. Use a hashset - O(nlogn)
 * 2. Use a trie 
 */

public class LongestWordInaDictionary {

	public static String LongestWordInaDict(String[] dict) {
		Arrays.sort(dict);
		Set<String> set = new HashSet<>();
		String answer = "";
		for (String word : dict) {
			if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
				answer = word.length() > answer.length() ? word : answer;
				set.add(word);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestWordInaDictionary a = new LongestWordInaDictionary();
		String[] input = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		System.out.println(LongestWordInaDict(input));
	}

}
