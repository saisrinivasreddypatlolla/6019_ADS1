import java.util.Scanner;
/**.
 * { item_description }
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
		String input;
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		for (int i = 0; i < size; i++) {
			BalancedParenthesis obj = new BalancedParenthesis();
			input = scan.next();
			obj.add(input);
			System.out.println(obj.check());

		}

	}
}
class BalancedParenthesis {
	/**.
	 * { var_description }
	 */
	private int size = 0;
	/**
	 * { item_description }
	 */
	private String[] stack;
	/**.
	 * { var_description }
	 */
	private String[] elements;
	/**.
	 * { function_description }
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
				stack[size++] = elements[i];
			} else if (elements[i].equals(
			               ")") || elements[i].equals(
			               "]") || elements[i].equals("}")) {
				if (size != 0) {
					if (elements[i].equals(")") && (
					            stack[size - 1].equals("("))) {
						size--;

					} else if (elements[i].equals("]") && (
					               stack[size - 1].equals("["))) {
						size--;
					} else if (elements[i].equals("}") && (
					               stack[size - 1].equals("{"))) {
						size--;
					}
				}
			}
		}
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String check() {
		if (size == 0) {
			return "YES";
		}
		return "NO";
	}

}