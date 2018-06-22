import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author subhadeepbhattacharyya One of the most horribly explained question
 *
 *         Abbreviation of a word is the first and last character of the string
 *         along with the length of the string in between. Unique abbreviation
 *         of a word is if any other word in the dictionary does not share the
 *         same abbreviation.
 * 
 * 
 */

public class UniqueWordAbbreviation {

	HashMap<String, Set<String>> Dictionary;

	public UniqueWordAbbreviation(String[] dict) {
		for (String s : dict) {
			String abbr = toAbbr(s);
			Set<String> abbreviation = Dictionary.containsKey(abbr) ? Dictionary.get(abbr) : new HashSet<>();
			abbreviation.add(abbr);
			Dictionary.put(abbr, abbreviation);
		}
	}

	public boolean isUnique(String word) {
		String abbr = toAbbr(word);
		Set<String> abbrev = Dictionary.get(abbr);
		return abbrev == null || (abbrev.size() == 1 && abbrev.contains(word));
	}

	public String toAbbr(String word) {
		if (word.length() < 2)
			return word;
		return word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
