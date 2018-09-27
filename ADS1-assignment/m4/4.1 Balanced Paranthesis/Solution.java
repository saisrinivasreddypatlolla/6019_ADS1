import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
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
	int size = 0;
	String[] stack, elements;
	public void add(String input) {
		int len = input.length();
		stack = new String[len];
		elements = input.split("");
		for (int i = 0; i < elements.length; i++) {
			// char a = elements.charAt(i);
			if (elements[i].equals("(") || elements[i].equals("[") || elements[i].equals("{")) {
				stack[size++] = elements[i];
			} else if (elements[i].equals(")") || elements[i].equals("]") || elements[i].equals("}")) {
				if (size != 0) {
					if (elements[i].equals(")")) {
						if (stack[size - 1].equals("(")) {
							size--;
						}
					} else if (elements[i].equals("]")) {
						if (stack[size - 1].equals("[")) {
							size--;
						}
					} else if (elements[i].equals("}")) {
						if (stack[size - 1].equals("{")) {
							size--;
						}
					}
				}
			}
		}
	}
	public String check() {
		if (size - 1 == 0) {
			return "YES";
		}
		return "NO";
	}

}