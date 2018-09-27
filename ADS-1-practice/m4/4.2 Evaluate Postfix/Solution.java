import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
	final static int twenty = 20;
	private static int[] stack = new int[twenty];
	private static int size = 0;
	public static void main(String[] args) {
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
	public static void operation(String operator) {
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