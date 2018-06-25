/*
 * We are given two strings namely:
 * S = "cba"
 * T = "abcd"
 * 
 * We are supposed to sort T in the similar way that the characters in S have been sorted and then append the remaining characters
 * in T to it.
 * So one possible answer is 
 * cbad
 * or 
 * dcba
 * 
 * How to Do It: Bucket Sort
 */

public class CustomOrderSortString {

	public String CustomOrder(String S, String T) {
		int[] count = new int[26]; // This array will keep a track of the elements of T
		for (char c : T.toCharArray())
			count[c - 'a']++;

		StringBuilder sb = new StringBuilder();
		for (char c : S.toCharArray()) {
			for (int i = 0; i < count[c - 'a']; i++)
				sb.append(c);
			count[c - 'a'] = 0;
		}

		for (char i = 'a'; i <= 'z'; i++) {
			for (int j = 0; j < count[i - 'a']; j++)
				sb.append(i);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		CustomOrderSortString obj = new CustomOrderSortString();
		String s = "cba";
		String t = "abcd";
		System.out.println(obj.CustomOrder(s, t));
	}

}
