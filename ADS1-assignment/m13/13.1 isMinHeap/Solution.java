import java.util.Scanner;
import java.lang.Comparable;
class MinHeap<E extends Comparable<E>> {
	MinHeap() {

	}
	public boolean check(E[] input) {
		int i = input.length - 1;
		while (i > 1) {
			if (input[i].compareTo(input[i / 2]) >= 0) {
				i -= 1;
			} else {
				return false;
			}
		}
		return true;
	}

}
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.nextLine();
		switch (type) {
		case "String":
			MinHeap<String> stringObj = new MinHeap<String>();
			int lines = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < lines; i++) {
				String item = scan.nextLine();
				if(item.length()==0){
					System.out.println("false");
					break;
				}
				String[] input = item.split(",");
				String[] values = new String[input.length + 1];
				for (int j = 0; j < input.length; j++) {
					values[j + 1] = input[j];
				}
				System.out.println(stringObj.check(input));
			}
			break;
		case "Integer":
			MinHeap<Integer> integerObj = new MinHeap<Integer>();
			lines = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < lines; i++) {
				String item = scan.nextLine();
				if(item.length()==0){
					System.out.println("false");
					break;
				}
				String[] input = item.split(",");
				Integer[] values = new Integer[input.length + 1];
				for (int j = 0; j < input.length; j++) {
					values[j + 1] = Integer.parseInt(input[j]);
				}
				System.out.println(integerObj.check(values));
			}
			break;
		case "Double":
			MinHeap<Double> doubleObj = new MinHeap<Double>();
			lines = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < lines; i++) {
				String item = scan.nextLine();
				if(item.length()==0){
					System.out.println("false");
					break;
				}
				String[] input = item.split(",");
				Double[] values = new Double[input.length + 1];
				for (int j = 0; j < input.length; j++) {
					values[j + 1] = Double.parseDouble(input[j]);
				}
				System.out.println(doubleObj.check(values));
			}
			break;
		case "Float":
			MinHeap<Float> floatObj = new MinHeap<Float>();
			lines = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < lines; i++) {
				String item = scan.nextLine();
				if(item.length()==0){
					System.out.println("false");
					break;
				}
				String[] input = item.split(",");
				Float[] values = new Float[input.length + 1];
				for (int k = 0; k < input.length; k++) {
					values[k + 1] = Float.parseFloat(input[k]);
				}
				System.out.println(floatObj.check(values));
			}
			break;
		}
	}
}