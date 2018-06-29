import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This is iterative
 */

public class FindAllSubsetsOfaSet {

	public List<List<Integer>> findSubsets(int[] set) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>()); // Well this is the empty set

		Arrays.sort(set);
		for (int i : set) {
			List<List<Integer>> temp = new ArrayList<>();
			for (List<Integer> sub : res) {
				List<Integer> a = new ArrayList<>(sub);
				a.add(i);
				temp.add(a);
			}
			System.out.println(temp);
			res.addAll(temp);
			System.out.println(res);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set = { 3, 2, 1 };
		// We need to return a list contains lists which are basically all the subsets
		// of the set
		// So it will be [],[3],[2],[1],[3,2],[3,1]..etc
		FindAllSubsetsOfaSet a = new FindAllSubsetsOfaSet();
		a.findSubsets(set).toString();

	}

}
