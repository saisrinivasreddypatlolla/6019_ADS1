import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
	/**.
	 * this is for size of array
	 */
	final static int TWENTY = 20;
	/**.
	 * stack to store numbers
	 */
	private static int[] stack = new int[TWENTY];
	/**.
	 * size of the given set of numbers
	 */
	private static int size = 0;
	/**.
	 * the main function is for the input and perform
	 * operations on them.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals("+") || input[i].equals(
			            "-") || input[i].equals(
			            "*") || input[i].equals("/")) {
				operation(input[i]);
			} else {
				stack[size++] = Integer.parseInt(input[i]);
			}
		}
		System.out.println(stack[0]);
	}
	/**.
	 * this method is used to perform operation.
	 *
	 * @param      operator  The operator
	 */
	public static void operation(final String operator) {
		if (operator.equals("+")) {
			stack[size - 2] = stack[size - 2] + stack[size - 1];
			size--;
		} else if (operator.equals("-")) {
			stack[size - 2] = stack[size - 2] - stack[size - 1];
			size--;
		} else if (operator.equals("*")) {
			stack[size - 2] = stack[size - 2] * stack[size - 1];
			size--;
		} else if (operator.equals("/")) {
			stack[size - 2] = stack[size - 2] / stack[size - 1];
			size--;
		}
	}
}