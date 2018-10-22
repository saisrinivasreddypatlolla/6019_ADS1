import java.util.Scanner;
/**.
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**.
     * this variable is the name of book
     */
    private String name;
    /**.
     * this variable represents the author name.
     */
    private String author;
    /**.
     * the price of the book
     */
    private double price;
    /**.
     * Constructs the object.
     *
     * @param      bookName    The book name
     * @param      authorName  The author name
     * @param      cost        The cost
     */
    Book(final String bookName, final String authorName,
         final double cost) {
        this.name = bookName;
        this.author = authorName;
        this.price = cost;
    }
    /**
     * Gets the name.
     *
     * @return     The name of book.
     */
    public String getName() {
        return this.name;
    }
    /**.
     * This method is to compare both book names
     * and return its value.
     * Time Complexity is O(1)
     *
     * @param      obj   The object
     *
     * @return     returns int value
     */
    public int compareTo(final Book obj) {
        return this.getName().compareTo(obj.getName());
    }
    public String toString(){
        return this.name+", "+this.author+", "
        +this.price;
    }
}
/**.
 * Class for binary search tree.
 *
 * @param      <Key>     Book object with book details
 * @param      <Values>  The values
 */
class BinarySearchT<Key extends Comparable<Key>, Values> {
    /**.
     * starting element in the BST.
     */
    private Node root;
    /**.
     * Class for node.
     */
    class Node {
        /**.
         * Object of Book class with book details.
         */
        private Key key;
        /**.
         * value of the book in Book class
         */
        private Values value;
        /**.
         * Right node of the BST
         */
        private Node right;
        /**.
         * Left node of BST.
         */
        private Node left;
        private int size;
        /**.
         * Constructs the object.
         *
         * @param      key1  The key 1
         * @param      val   The value
         */
        Node(final Key key1, final Values val, final int size1) {
            this.key = key1;
            this.value = val;
            this.size = size1;
        }

    }
    /**.
     * This method is to add a key and value to BST.
     * Time Complexity is O(1).
     * because it calls another put method to add elements.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Values value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }
    /**.
     * This method is to add element to BST
     * Time Complexity is O(N) for worst case.
     * element is added until it reaches to the
     * position it should added at.
     *
     * @param      node   The node
     * @param      key    The key
     * @param      value  The value
     *
     * @return     returns node
     */
    public Node put(final Node node, final Key key,
                    final Values value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }
    /**.
     * This method is to return the value of that key
     * Time Complexity is O(N)
     *
     * @param      key   The key
     *
     * @return     returns the value.
     */
    public Values get(final Key key) {
        return get(root, key);
    }
    /**.
     * This method is to return the value of that key
     * Time Complexity is O(N)
     *
     * @param      node  the node where the book details and
     *                   values.
     * @param      key   The key
     *
     * @return     returns the value of that key.
     */
    private Values get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }
    public Key select(int k) {
        Node x = select(root, k);
        return x.key;
    }
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    }

}
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * main method to perform operations
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchT<Book, Integer> obj = new BinarySearchT<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                obj.put(new Book(tokens[1], tokens[2], Double.parseDouble(
                                     tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                System.out.println(obj.get(new Book(
                                               tokens[1], tokens[2],
                                               Double.parseDouble(
                                                   tokens[2 + 1]))));
                break;
            case "max":
                System.out.println(obj.max());
                break;
            case "min":
                System.out.println(obj.min());
                break;
            case "floor":
                System.out.println(obj.floor(
                                       new Book(tokens[1], tokens[2],
                                                Double.parseDouble(
                                                    tokens[2 + 1]))));
                break;
            case "ceiling":
                System.out.println(obj.ceiling(
                                       new Book(tokens[1], tokens[2],
                                                Double.parseDouble(
                                                    tokens[2 + 1]))));
                break;
            case "select":
                System.out.println(obj.select(Integer.parseInt(tokens[1])));
                break;
            default:
                break;
            }
        }
    }
}
