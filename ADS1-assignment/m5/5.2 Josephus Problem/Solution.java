import java.util.Scanner;
/**.
 * Solution class
 */
public final class Solution {
    /**.
     * Sollution constructor
     */
    private Solution() {
        //Solution constructor
    }
    /**.
     * main method to handle the testcases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * scanner object to read the data
         */
        Scanner scan = new Scanner(System.in);
        /**.
         * Queue object to store the given data
         */
        Queue queueObj = new Queue();
        /**.
         * Variable to define the no of inputs
         */
        int noOfInputs = Integer.parseInt(scan.nextLine());
        for (int index1 = 0; index1 < noOfInputs; index1++) {
            String[] tokens = scan.nextLine().split(" ");
            int number = Integer.parseInt(tokens[0]);
            int position = Integer.parseInt(tokens[1]);
            /**.
             * adding given elements into the Queue.
             */
            for (int index = 0; index < number; index++) {
                queueObj.enQueue(index);
            }
            /**.
             * Checking of mth position person and poping the same
             */
            while (!queueObj.isEmpty() && number != 1) {
                for (int i = 1; i < position; i++) {
                    queueObj.enQueue(queueObj.deQueue());
                }
                System.out.print(queueObj.deQueue() + " ");
                number--;
            }
            System.out.print(queueObj.deQueue());
            System.out.println();
            //System.out.println("while completed");
        }
    }
}
/**.
 * Queue class for queue implementaion
 */
class Queue {
    /**.
     * size variable
     */
    private int size;
    /**.
     * Node obj creation
     */
    private Node queue;
    /**.
     * Head node creation for referance
     */
    private Node head;
    /**.
     * Node class
     */
    class Node {
        /**.
         * data variable to store the data
         */
        private int data;
        /**.
         * Node object to point to the next Node
         */
        private Node link;
        /**.
         * Node constructor without arguments
         */
        Node() {
            this.data = 0;
            this.link = null;
        }
        /**.
         * Node constructor with arguments
         *
         * @param      data1  The data
         */
        Node(final int data1) {
            this.data = data1;
            this.link = null;
        }
    }
    /**.
     * Queue constructor
     */
    Queue() {
        queue = new Node();
        size = 0;
    }
    /**.
     * enQueue method to add the element at the head
     *
     * @param      data  The data
     */
    public void enQueue(final int data) {
        if (size == 0) {
            head = new Node(data);
            size++;
            return;
        }
        Node start = new Node(data);
        start.link = head;
        head = start;
        size++;
        return;
    }
    /**.
     * method to remove the element at the end
     *
     * @return     { description_of_the_return_value }
     */
    public int deQueue() {
        Node current = head;
        if (size == 1) {
            size--;
            int n = head.data;
            head = null;
            return current.data;
        }

        int counter = 1;
        while (counter < size - 1) {
            counter++;
            current = current.link;
        }
        int data = current.link.data;
        current.link = null;
        size--;
        return data;
    }
    /**.
     * Checks weather Queue is empty or not
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**.
     * Getter method for sizes
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
}