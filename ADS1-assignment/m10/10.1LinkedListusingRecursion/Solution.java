import java.util.Scanner;
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
     * main method is used to take the input and perform
     * operations on them.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedList linkedlistobj = new LinkedList();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            try {
                switch (tokens[0]) {
                case "insertAt":
                    linkedlistobj.insertAt(
                        Integer.parseInt(
                            tokens[1]), Integer.parseInt(
                            tokens[2]));
                    linkedlistobj.print();
                    break;
                case "reverse":
                    linkedlistobj.reverse();
                    linkedlistobj.print();
                    break;
                default:
                    break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
/**.
 * List of linkeds.
 */
class LinkedList {
    /**.
     * Class for node.
     */
    class Node {
        /**.
         * this variable stores the data
         */
        private int item;
        /**.
         * the variable stores the address of next node.
         */
        private Node next;
        /**.
         * Constructs the object.
         *
         * @param      item1  The item 1
         */
        Node(final int item1) {
            this.item = item1;
        }
        /**.
         * returns the current data.
         *
         * @return     The item.
         */
        public int getItem() {
            return this.item;
        }
        /**.
         * returns the address of
         * next node.
         *
         * @return     The next.
         */
        public Node getNext() {
            return next;
        }
        /**.
         * Sets the address.
         *
         * @param      next1  The next 1
         */
        public void setNext(final Node next1) {
            this.next = next1;
        }
    }
    /**.
     * this variable stroes the count of
     * elements stroed in linked list.
     */
    private int size = 0;
    /**.
     * this variable points to the first element
     * in linked list.
     */
    private Node head = null;
    /**.
     * this method is to add the elements
     * to linkedlist
     * Time complexity of this method is O(1)
     *
     * @param      index      The index
     * @param      item       The item
     *
     * @throws     Exception  user defined exception
     *                        if the index is less than 0 or greater than
     *                        size
     */
    public void insertAt(final int index, final int item)throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Can't insert at this position.");
        }
        Node temp = new Node(item);
        head = insertAt(head, temp, index, 0);
        size++;

    }
    /**.
     * this method inserts the value in linked list
     * Time complexity of this method is O(N)
     * insert the value at the desired position the function calls itself
     * until reaches to the desired position.
     *
     * @param      current  The current
     * @param      temp     The temporary
     * @param      index    The index
     * @param      count    The count
     *
     * @return     { description_of_the_return_value }
     */
    private Node insertAt(final Node current, final Node temp,
                          final int index, final int count) {
        if (head == null) {
            return temp;
        }
        if (count == index) {
            temp.setNext(current);
            return temp;
        }
        current.setNext(insertAt(current.next, temp, index, count + 1));
        return current;
    }
    /**.
     * this method reverse the values from starting position
     * to last position.
     * Time complexity is O(1)
     * it call other reverse method.
     *
     * @throws     Exception  throw exception if head is null
     */
    public void reverse() throws Exception {
        if (head == null) {
            throw new Exception("No elements to reverse.");
        }
        reverse(head, null);
    }
    /**.
     * this method reverse the values from starting position
     * to last position.
     * Time complexity is O(N)
     * it calls itself until all elements are reversed.
     *
     * @param      current  The current
     * @param      prev     The previous
     */
    private void reverse(final Node current, final Node prev) {
        if (current.next == null) {
            head = current;
            head.setNext(prev);
            return;
        }
        Node temp = current.getNext();
        current.setNext(prev);
        reverse(temp, current);
    }
    /**.
     * this method prints all elements
     * Time complexity is O(N)
     * it will iterate until all the elements are printed.
     */
    public void print() {
        Node obj = head;
        while (obj.getNext() != null) {
            System.out.print(obj.item + ", ");
            obj = obj.getNext();
        } System.out.print(obj.item);
        System.out.println();
    }
}
