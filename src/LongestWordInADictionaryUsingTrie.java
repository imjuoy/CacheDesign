
public class LongestWordInADictionaryUsingTrie {

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}

	class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
			root.word = "";
		}

		public void AddWord(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null)
					node.children[c - 'a'] = new TrieNode();
				node = node.children[c - 'a'];
			}
			node.word = word;
		}
	}

	public String LongestWord(String[] word) {
		Trie trie = new Trie();
		for (String w : word) {
			trie.AddWord(w);
		}
		String[] result = new String[] { "" };
		dfs(trie.root, result);
		return result[0];
	}

	public void dfs(TrieNode node, String[] result) {
		if (node.word == null)
			return;
		if (node.word.length() > result[0].length())
			result[0] = node.word;
		for (TrieNode child : node.children) {
			if (child != null)
				dfs(child, result);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
