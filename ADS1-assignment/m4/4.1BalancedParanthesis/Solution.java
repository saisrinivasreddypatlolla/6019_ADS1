import java.util.Scanner;
/**.
 * the main class for checking
 * balanced parenthesis
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * main function takes input fro console
     * checks the given input is balanced or not.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        for (int i = 0; i < lines; i++) {
            BalancedParenthesis obj = new BalancedParenthesis();
            input = scan.next();
            obj.add(input);
            System.out.println(obj.checkInput());

        }

    }
}
/**.
 * Class for check given method is
 * balanced parenthesis.
 */
class BalancedParenthesis {
    /**.
     * size of the stack array
     */
    private int size = 0;
    /**.
     * store the open braces
     */
    private String[] stack;
    /**.
     * store the input elements
     */
    private String[] elements;
    /**.
     * this method is to add inputs
     * and perform stack operations on it.
     *
     * @param      input  The input
     */
    public void add(final String input) {
        int len = input.length();
        stack = new String[len];
        elements = input.split("");
        for (int i = 0; i < elements.length; i++) {
            // char a = elements.charAt(i);
            if (elements[i].equals(
                        "(") || elements[i].equals(
                        "[") || elements[i].equals("{")) {
                push(elements[i]);
            } else if (elements[i].equals(
                           ")") || elements[i].equals(
                           "]") || elements[i].equals("}")) {
                if (size != 0) {
                    if (elements[i].equals(")") && (
                                stack[size - 1].equals(
                                    "("))) {
                        pop();

                    } else if (elements[i].equals("]") && (
                                   stack[size - 1].equals(
                                       "["))) {
                        pop();
                    } else if (elements[i].equals("}") && (
                                   stack[size - 1].equals(
                                       "{"))) {
                        pop();
                    }
                }
            }
        }
    }
    /**.
     * this method adds the element into stack
     *
     * @param      element  The element
     */
    public void push(final String element) {
        stack[size++] = element;
    }
    /**.
     * this method to delete element
     */
    public void pop() {
        size--;
    }
    /**.
     * this method returns yes if the size is empty
     * else returns no
     *
     * @return     returns yes if the size is empty
     *             else returns no
     */
    public String checkInput() {
        if (size == 0) {
            return "YES";
        }
        return "NO";
    }

}
