import java.util.Scanner;
/**
 * Class for merge.
 */
class Merge {
	/**
	 * cutoff to insertion sort.
	 */
	private final int CUTOFF = 7;
	/**
	 * Constructs the object.
	 * Time complexity of this method is O(1).
	 */
	Merge() {
		//Unused Constructor.
	}
	/**
	 * {Method to merge two arrays}.
	 * Time complexity of this method is O(N).
	 * @param      array  The array
	 * @param      aux    The auxiliary
	 * @param      low     The lowwer value
	 * @param      mid    The middle value
	 * @param      high     The higher value
	 */
	public void merge(final Comparable[] array, final Comparable[] aux,
	                  final int low, final int mid, final int high) {
		assert isSorted(array, low, mid);
		assert isSorted(array, mid + 1, high);
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				aux[k] = array[j++];
			} else if (j > high) {
				aux[k] = array[i++];
			} else if (less(array[j], array[i])) {
				aux[k] = array[j++];
			} else {
				aux[k] = array[i++];
			}
		}
		assert isSorted(aux, low, high);
	}
	/**
	 * {Method for sorting}.
	 * Time complexity of sorting is O(lowg(N)).
	 * @param      array  The array
	 * @param      aux    The auxiliary array
	 * @param      low     The lowwer value
	 * @param      high     The higher value
	 */
	public void sort(final Comparable[] array, final Comparable[] aux,
	                 final int low, final int high) {
		if (high <= low + CUTOFF) {
			insertionSort(aux, low, high);
			System.out.println("Insertion sort method invoked...");
			return;
		}
		int mid = low + (high - low) / 2;
		sort(aux, array, low, mid);
		sort(aux, array, mid + 1, high);
		if (!less(array[mid + 1], array[mid])) {
			for (int i = low; i <= high; i++) {
				aux[i] = array[i];
			}
			System.out.println(
			    "Array is already sorted. So, skipped the call to merge...");
			return;
		}
		merge(array, aux, low, mid, high);
	}
	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * Time complexity of this method is O(N).
	 * @param      array     {Comparable array}.
	 */
	public void sort(final Comparable[] array) {
		Comparable[] aux = array.clone();
		sort(aux, array, 0, array.length - 1);
		assert isSorted(array);
	}
	/**
	 * {Method for insertion sort}.
	 * sort from array[low] to array[high].
	 * Time complexity of insertion sort is O(N^2/2).
	 * @param      array     {Comparable array}.
	 * @param      low    The lowwer value
	 * @param      high    The higher value
	 */
	public void insertionSort(final Comparable[] array,
	                          final int low, final int high) {
		for (int i = low; i <= high; i++) {
			for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
				exch(array, j, j - 1);
			}
		}
	}
	/**
	 * {Method to exchange two elements in the array}.
	 * Time complexity of this method is O(N).
	 * @param      array     {Array of object}
	 * @param      i     {Integer i}
	 * @param      j     {Integer j}
	 */
	public void exch(final Comparable[] array,
	                 final int i, final int j) {
		Comparable swap = array[i];
		array[i] = array[j];
		array[j] = swap;
	}
	/**
	 * {Method to check which one is smaller of the two}.
	 * Time complextiy of this method is O(1).
	 * @param      array     {Comparable}.
	 * @param      b     {Comparable}.
	 *
	 * @return     {Boolean value}.
	 */
	public boolean less(final Comparable array, final Comparable b) {
		return array.compareTo(b) < 0;
	}
	/**
	 * Method to determine if the array is sorted (or) not.
	 * Time complexity of this method is O(1).
	 * @param      array     {Comparable array}
	 *
	 * @return     True if sorted, False otherwise.
	 */
	public boolean isSorted(final Comparable[] array) {
		return isSorted(array, 0, array.length - 1);
	}
	/**
	 * Method to determine if the array is sorted (or) not.
	 * Time complexity of this method is O(N).
	 * @param      array     {Comparable array}
	 * @param      low    The lowwer
	 * @param      high    The higher
	 *
	 * @return     True if sorted, False otherwise.
	 */
	public boolean isSorted(final Comparable[] array,
	                        final int low, final int high) {
		for (int i = low + 1; i <= high; i++) {

			if (less(array[i], array[i - 1])) {
				return false;
			}
		}
		return true;
	}
	/**
	 * {Method to print the values of the Comparable array}.
	 * Time complexity of this method is O(N).
	 * @param      array     {Name of object array}
	 *
	 * @return     {String}
	 */
	public String show(final Comparable[] array) {
		String str = "[";
		int i;
		for (i = 0; i < array.length - 1; i++) {
			str += array[i] + ", ";
		}
		str += array[i] + "]";
		return str;
	}
}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 * Time complexity of this method is O(1).
	 */
	private Solution() {
		//Unused Constructor.
	}
	/**
	 * {Client Program}.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		Merge m = new Merge();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			m.sort(tokens);
			System.out.println(m.show(tokens));
			System.out.println();
		}
	}
}
