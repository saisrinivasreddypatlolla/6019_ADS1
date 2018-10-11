import java.util.Scanner;
class Book implements Comparable<Book> {
	String name;
	String author;
	double price;
	Book(String bookName, String authorName, double cost) {
		this.name = bookName;
		this.author = authorName;
		this.price = cost;
	}
	public String getName() {
		return this.name;
	}
	public int compareTo(Book obj) {
		return this.getName().compareTo(obj.getName());
	}
}
class BinarySearchT<E extends Comparable<E>, Values> {
	Node root;
	class Node {
		Book key;
		Values value;
		Node right;
		Node left;
		Node(Book key1, Values val) {
			this.key = key1;
			this.value = val;
		}

	}
	public void put(Book key, Values value) {
		if(key == null){
			return;
		}
		root = put(root, key, value);
	}
	public Node put(Node node, Book key, Values value) {
		if (node == null) {
			return new Node(key, value);
		}
		int cmp = key.getName().compareTo(node.key.getName());
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else if (cmp > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		return node;
	}
	public Values get(Book key) {
        return get(root, key);
    }

    private Values get(Node x, Book key) {
        // if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.getName().compareTo(x.key.getName());
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.value;
    }
}
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchT<Book, Integer> obj = new BinarySearchT<>();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch (tokens[0]) {
			case "put":
				obj.put(new Book(tokens[1], tokens[2], Double.parseDouble(
				                     tokens[3])), Integer.parseInt(tokens[4]));
				break;
			case "get":
				System.out.println(obj.get(new Book(
				                               tokens[1], tokens[2],
				                               Double.parseDouble(
				                                   tokens[3]))));
			}
		}
	}
}