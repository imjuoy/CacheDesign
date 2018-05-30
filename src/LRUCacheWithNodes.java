import java.util.HashMap;
import java.util.Map;

public class LRUCacheWithNodes {

	class Node {
		Object key;
		Object value;
		Node pre;
		Node post;

		public Node(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

	}

	int capacity;
	Map<Object, Node> cache;
	Node head = null;
	Node tail = null;

	public LRUCacheWithNodes(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.post = tail;
		tail.pre = head;
	}

	public Object get(Object key) {
		Object value = cache.get(key);
		if (value != null) {
			Node result = cache.get(key);
			moveToHead(result);
			return result.value;
		}
		return -1;
	}

	public void put(Object key, Object value) {
		// Node newNode = new Node(key, value);
		Node existingNode = cache.get(key);
		if (cache.containsKey(key)) {
			existingNode.value = value;
			moveToHead(existingNode);
		} else if (cache.size() == capacity) {
			Node tail = poptail();
			cache.remove(tail.key);
		}
		Node newNode = new Node(key, value);
		AddtoHead(newNode);
		cache.put(key, newNode);

	}

	private void AddtoHead(Node node) {
		node.pre = head;
		node.post = head.post;
		head.post.pre = node;
		head.post = node;
	}

	private void removeNode(Node node) {
		Node pre = node.pre;
		Node post = node.post;

		pre.post = post;
		post.pre = pre;

	}

	private void moveToHead(Node node) {
		removeNode(node);
		AddtoHead(node);
	}

	private Node poptail() {
		Node result = tail.pre;
		removeNode(result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRUCacheWithNodes a = new LRUCacheWithNodes(2);
		a.put(1, 1);
		a.put(2, 2);
		System.out.println(a.get(1));
		a.put(3, 3);
		System.out.println(a.get(2));

	}

}
