import java.util.Arrays;

/**
 * Least Frequently Used Cache
 * 
 * @author subhadeepbhattacharyya
 *
 */

public class LFU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "mynameisjoy";
		int[] chars = new int[26];
		for (Character c : s.toCharArray())
			chars[c - 'a']++;

		System.out.println(Arrays.toString(chars));
	}

}
