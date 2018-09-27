import java.util.Scanner;
class Solution{
	public static void main(String[] args) {
		String[] stack = new String[20];
		int size =0;
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		for(int i=0;i<input.length;i++){
			if(input[i].equals("-")){
				size--;
				System.out.println(stack[size]);
			} else{
				stack[size++] = input[i];
			}
		}
	}
}