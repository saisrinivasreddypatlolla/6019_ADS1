import java.util.Scanner;
/**.
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**.
     * { var_description }
     */
    String name;
    /**.
     * { var_description }
     */
    String author;
    /**.
     * { var_description }
     */
    double price;
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
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * { function_description }
     *
     * @param      obj   The object
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Book obj) {
        return this.getName().compareTo(obj.getName());
    }
}
/**.
 * Class for binary search t.
 *
 * @param      <E>       { parameter_description }
 * @param      <Values>  The values
 */
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
    /**.
     * { function_description }
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final Values value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }
    /**.
     * { function_description }
     *
     * @param      node   The node
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { description_of_the_return_value }
     */
    public Node put(final Node node, final Book key,
        final Values value) {
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
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Values get(Book key) {
        return get(root, key);
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Values get(final Node x, final Book key) {
        if (x == null) return null;
        int cmp = key.getName().compareTo(x.key.getName());
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.value;
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
     * { function_description }
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