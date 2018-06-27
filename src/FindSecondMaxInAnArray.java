
public class FindSecondMaxInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 1, 2, 3 };
		Integer max1 = null;
		Integer max2 = null;

		for (Integer num : input) {
			if (num.equals(max1) || num.equals(max2))
				continue;
			if (max1 == null || num > max1) {
				max2 = max1;
				max1 = num;
			} else if (max2 == null || num > max2)
				max2 = num;
		}
		Integer result = max2 == null ? max1 : max2;
		System.out.println(result);
		System.out.println("");
	}

}
