import java.util.Scanner;
class Solution {
	static int[] stack = new int[20];
	static int size = 0;
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
	}
	public static void operation(String operator){
		if(operator.equals("+")){
			stack[size-2] = stack[size-2]+stack[size-1];
			size--;
		}else if(operator.equals("-")){
			stack[size-2] = stack[size-2]+stack[size-1];
			size--;
		}else if(operator.equals("*")){
			stack[size-2] = stack[size-2]+stack[size-1];
			size--;
		}else if(operator.equals("/")){
			stack[size-2] = stack[size-2]+stack[size-1];
			size--;
		}
	}
}