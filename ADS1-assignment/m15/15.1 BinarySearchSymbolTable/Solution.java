import java.util.Arrays;
import java.util.Scanner;
class BinarySearchST<Keys extends Comparable<Keys>, Values> {
	private Keys[] keys;
	private Values[] values;
	private int size;
	BinarySearchST() {
		keys = (Keys[]) new Comparable[10];
		values = (Values[]) new Comparable[10];
		size = 0;
	}
	private void resize() {
		keys = Arrays.copyOf(keys, size + 1);
		values = Arrays.copyOf(values, size + 1);
	}
	public void put(Keys key, Values value) {
		if (size == keys.length) {
			resize();
		}
		if(size==0){
			keys[0]=key;
			values[0]=value;
			size++;
			return;
		}
		int rank = rank(key);
		if (rank < size && keys[rank].compareTo(key) == 0) {
			values[rank] = value;
			return;
		}
		for (int i = size; i > rank; i--) {
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}
		keys[rank] = key;
		values[rank] = value;
		size++;
	}
	public int rank(Keys key) {
		int low = 0;
		int high = size-1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key.compareTo(keys[mid]) < 0) {
				high = mid - 1;
			} else if (key.compareTo(keys[mid]) > 0) {
				low = mid + 1;
			} else {
				return mid;
			}


		}
		return low;

	}
	public void delete(Keys key) {
		int rank = rank(key);
		for (int i = rank; i < size - 1; i++) {
			keys[i] = keys[i + 1];
			values[i] = values[i + 1];
		}
		size--;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public boolean contains(Keys key) {
		return get(key) != null;
	}
	public Values get(Keys key) {
		if (isEmpty()) {
			return null;
		}
		int rank = rank(key);
		if (rank < size && keys[rank].compareTo(key) == 0) {
			return values[rank];
		}
		return null;
	}
	public void deleteMin() {
		delete(min());
	}
	public void deleteMax() {
		delete(max());
	}
	public Keys min() {
		return keys[0];
	}
	public Keys max() {
		return keys[size - 1];
	}
	public Keys select(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return keys[index];
	}
	public Keys floor(Keys key) {
		int rank = rank(key);
		if ((rank < size) && (key.compareTo(keys[rank])) == 0) {
			return keys[rank];
		}
		return keys[rank - 1];
	}
	public Keys ceiling(Keys key) {
		int rank = rank(key);
		// if(rank<size&&key.compareTo(keys[rank])){
		return keys[rank];
		// }
		// return
	}
	public void keys() {
		for (int i = 0; i < size; i++) {
			System.out.println(keys[i] + " " + values[i]);
		}
	}
}
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		BinarySearchST<String, Integer> obj = new BinarySearchST<>();
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(" ");
		for (int i = 0; i < tokens.length; i++) {
			obj.put(tokens[i], i);
		}
		while (scan.hasNext()) {
			String[] input = scan.nextLine().split(" ");
			switch(input[0]){
			case "deleteMin":
				obj.deleteMin();
				break;
			case "deleteMax":
				obj.deleteMax();
				break;
			case "max":
				System.out.println(obj.max());
				break;
			case "min":
				System.out.println(obj.min());
				break;
			case "rank":
				System.out.println(obj.rank(input[1]));
				break;
			case "contains":
				System.out.println(obj.contains(input[1]));
				break;
			case "get":
				System.out.println(obj.get(input[1]));
				break;
			case "keys":
				obj.keys();
				break;
			case "floor":
				System.out.println(obj.floor(input[1]));
				break;
			case "ceiling":
				System.out.println(obj.ceiling(input[1]));
				break;
			default:
				break;
			}
		}
	}
}