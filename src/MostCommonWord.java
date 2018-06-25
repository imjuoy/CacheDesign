import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author subhadeepbhattacharyya This is one of the most common question for
 *         Amazon. Given a sentence, a list of banned words, return the word
 *         with the highest frequency which is not present in the banned words
 *         list
 *
 */

public class MostCommonWord {

	public static String wordFrequency(String sentence, String[] bannedWord) {
		// Declare a set and push all the words to the set to maintain a distinct set of
		// banned words
		Set<String> set = new HashSet<>();
		for (String s : bannedWord) {
			set.add(s);
		}
		Map<String, Integer> map = new HashMap<String, Integer>();// This will store the word frequency
		int count = 0;
		String answer = "";
		for (String s : sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ")) {
			s = s.trim();
			if (s.length() == 0 || set.contains(s))
				continue;
			map.put(s, map.getOrDefault(s, 0) + 1);
			if (count < map.get(s)) {
				count = map.get(s);
				answer = s;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
