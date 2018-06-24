import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeString {

	public String EncodeString(String[] strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length()).append('/').append(s);
		}
		return sb.toString();
	}

	public List<String> DecodeString(String s) {
		int i = 0;
		List<String> ls = new ArrayList<String>();
		while (i < s.length()) {
			int slash = s.indexOf('/', i);
			int size = Integer.valueOf(s.substring(i, slash + 1));
			ls.add(s.substring(slash + 1, slash + size + 1));
			i = slash + size + 1;
		}
		return ls;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
