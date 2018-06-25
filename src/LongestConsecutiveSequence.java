import java.util.HashSet;
import java.util.Set;

/*
 * Three ways to do it:
 * 
 * 1. Brute- Force method - O(n^3) - TLE
 * 2. Sorting - O(nlogn) 
 * 3. Hashset - O(n)
 */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> set = new HashSet<>();
		int[] input = { 5, 7, 1, 2, 3, 4 };
		for (int num : input) {
			set.add(num);
		}
		int longestStreak = 0;
		for (int num : set) {
			if (!set.contains(num - 1)) {
				int currentStreak = 1;
				int currentNum = num;
				while (set.contains(currentNum + 1)) {
					currentNum++;
					currentStreak++;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		System.out.print(longestStreak);

	}

}
