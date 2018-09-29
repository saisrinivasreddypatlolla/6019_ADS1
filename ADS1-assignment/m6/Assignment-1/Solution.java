import java.util.Scanner;
/**.
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    static final int TEN = 10;
    /**.
     * Constructs the object.
     */
    private AddLargeNumbers() {

    }
    /**.
     * { function_description }
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList listObj = new LinkedList();
        String[] digits = number.split("");
        for (int i = 0; i < digits.length; i++) {
            listObj.addEnd(Integer.parseInt(digits[i]));
        }
        return listObj;

    }
    /**.
     * { function_description }
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.toString();
    }
    /**.
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(
        final LinkedList list1, final LinkedList list2) {
        LinkedList listObj = new LinkedList();
        int size = 0;
        if (list1.getSize() < list2.getSize()) {
            size = list2.getSize();
        } else {
            size = list1.getSize();
        }
        int carry = 0, value = 0;
        for (int i = size; i > 0; i--) {
            value = list1.removeEnd() + list2.removeEnd();
            value = value + carry;
            carry = value / TEN;
            value = value % TEN;
            listObj.addStart(value);
        }
        if (carry > 0) {
            listObj.addStart(carry);
        }
        return listObj;

    }
}
/**.
 * Class for solution.
 */
public final class Solution {
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
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(
                                    pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
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
         * { var_description }
         */
        private int digit;
        /**.
         * { var_description }
         */
        private Node address;
        /**.
         * Constructs the object.
         *
         * @param      item  The item
         */
        Node(final int item) {
            this.digit = item;
        }
        /**.
         * Gets the digit.
         *
         * @return     The digit.
         */
        public int getDigit() {
            return this.digit;
        }
        /**.
         * Gets the address.
         *
         * @return     The address.
         */
        public Node getAddress() {
            return this.address;
        }
        /**.
         * Sets the address.
         *
         * @param      address1  The address 1
         */
        public void setAddress(final Node address1) {
            this.address = address1;
        }
    }
    /**.
     * { var_description }
     */
    private int size = 0;
    /**.
     * { var_description }
     */
    private Node head;
    /**.
     * { var_description }
     */
    private Node tail;
    /**.
     * Adds an end.
     *
     * @param      item  The item
     */
    public void addEnd(final int item) {
        if (size == 0) {
            head = new Node(item);
            tail = head;
            head.setAddress(null);
            size++;
            return;
        }
        Node temp = new Node(item);
        temp.setAddress(null);
        tail.setAddress(temp);
        tail = temp;
        size++;
    }
    /**.
     * Removes an end.
     *
     * @return     { description_of_the_return_value }
     */
    public int removeEnd() {
        if (head == null) {
            return 0;
        }
        if (size == 1) {
            int data = head.getDigit();
            head = null;
            tail = null;
            return data;
        }
        Node temp = head;
        while (temp.getAddress().getAddress() != null) {
            temp = temp.getAddress();
        }
        int data = temp.getAddress().getDigit();
        temp.setAddress(null);
        tail = temp;
        size--;
        return data;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        Node temp = head;
        String str = "";
        while (temp.getAddress() != null) {
            str += temp.getDigit();
            temp = temp.getAddress();
        }
        return str + temp.getDigit();
    }
    /**.
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**.
     * Adds a start.
     *
     * @param      item  The item
     */
    public void addStart(final int item) {
        if (size == 0) {
            head = new Node(item);
            head.setAddress(null);
            tail = head;
            size++;
            return;
        }
        Node temp = new Node(item);
        temp.setAddress(head);
        head = temp;
        size++;
    }
}
