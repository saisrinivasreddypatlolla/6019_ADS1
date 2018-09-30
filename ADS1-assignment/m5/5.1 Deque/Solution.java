import java.util.Scanner;
/**.
 * Solution class
 */
public final class Solution {
    /**.
     * Constructor
     */
    private Solution() {
        //Constructor
    }
    /**.
     * Main method to handle the test cases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "pushLeft":
                d.pushLeft(Integer.parseInt(tokens[1]));
                break;
            case "pushRight":
                d.pushRight(Integer.parseInt(tokens[1]));
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "isEmpty":
                System.out.println(d.isEmpty());
                break;
            case "popLeft":
                d.popLeft();
                break;
            case "popRight":
                d.popRight();
                break;
            default:
                //This is light
                break;
            }
        }
    }
}
/**.
 * Dequeue class for the implimentaion of dequeue
 *
 * @param      <E>   { Generic }
 */
class Deque<E> {
    /**.
     * Size variable
     */
    private int size;
    /**.
     * Object for linked list
     */
    private LinkedList<E> linkedQueue;
    /**.
     * Constructs the object.
     */
    Deque() {
        linkedQueue = new LinkedList<E>();
        size = 0;
    }
    /**.
     * is empty method to check weather dequeqe is empty or not
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**.
     * Size method to know the size
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**.
     * Push left method to put the element at the left end
     *
     * @param      item  The item
     */
    public void pushLeft(final E item) {
        linkedQueue.addAtStart(item);
        size++;
        linkedQueue.print();
    }
    /**.
     * push right method to push the element in right end
     *
     * @param      item  The item
     */
    public void pushRight(final E item) {
        linkedQueue.addAtEnd(item);
        size++;
        linkedQueue.print();
    }
    /**.
     * remove the elemenet from left end
     */
    public void popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        size--;
        linkedQueue.removeAtStart();
        if (linkedQueue.getSize() == 0) {
            System.out.println("[]");
            return;
        }
        linkedQueue.print();
    }
    /**.
     * removing from right end;
     */
    public void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        size--;
        linkedQueue.removeAtEnd();
        if (linkedQueue.getSize() == 0) {
            System.out.println("[]");
            return;
        }
        linkedQueue.print();
    }



}