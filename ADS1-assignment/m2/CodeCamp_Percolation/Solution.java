import java.util.Scanner;
/**.
 * class for finding given grid satisfies the percolation
 * or not.
 */
class Percolation {
	/**.
	 * boolean matrix to store connections
	 */
	private boolean[] matrix;
	/**.
	 * size of the give grid.
	 */
	private int size;
	/**.
	 * size of the union id grid.
	 */
	private int gridSize;
	/**.
	 * number of connections
	 */
	private int count = 0;
	/**.
	 * WeightedQuickUnionUF object
	 */
	private WeightedQuickUnionUF ufObject;
	/**.
	 * Constructs the object and assigns all values.
	 *
	 * @param      size1     size of the grid.
	 */
	Percolation(final int size1) {
		matrix = new boolean[(size1 * size1)];
		size = size1;
		gridSize = size1 * size1;
		ufObject = new WeightedQuickUnionUF(size * size + 2);
	}
	/**.
	 * this method connects the two nodes using given rows and columns
	 *
	 * @param      row   The row of grid
	 * @param      col   The column of grid
	 */
	public void open(final int row, final int col) {
		if (!(isOpen(row, col))) {
			matrix[(row * size) + col] = true;
			count++;
			if (row - 1 >= 0 && isOpen(row - 1, col)) {
				ufObject.union(indexOf(row, col), indexOf(
				                   row - 1, col));
			}
			if (row + 1 < (size) && isOpen(row + 1, col)) {
				ufObject.union(indexOf(row, col), indexOf(
				                   row + 1, col));
			}
			if (col - 1 >= 0 && isOpen(row, col - 1)) {
				ufObject.union(indexOf(row, col), indexOf(
				                   row, col - 1));
			}
			if (col + 1 < (size) && isOpen(row, col + 1)) {
				ufObject.union(indexOf(row, col), indexOf(
				                   row, col + 1));
			}
			if (row == 0) {
				ufObject.union(indexOf(row, col), gridSize);
			}
			if (row == size - 1) {
				ufObject.union(indexOf(row, col), gridSize + 1);
			}
		}
	}
	/**.
	 * calcutates the index of array and returns it.
	 *
	 * @param      row   The row of grid
	 * @param      col   The column of grid
	 *
	 * @return     returns the index of array.
	 */
	private int indexOf(final int row, final int col) {
		return (size * row) + col;
	}
	/**.
	 * Determines if the given position is open or not.
	 *
	 * @param      row   The row of grid
	 * @param      col   The column of grid
	 *
	 * @return     True if open, False otherwise.
	 */
	public boolean isOpen(final int row, final int col) {
		int index = (row * size) + col;
		if (matrix[index] == false) {
			return false;
		}
		return true;
	}
	// public boolean isFull(int row, int col)
	// is site (row, col) full?
	/**.
	 * this method returns number of connections.
	 *
	 * @return     returns number of connectionsin grid.
	 */
	public int numberOfOpenSites() {
		return count;
	}
	/**.
	 * this method checks the given grid is percolates
	 * or not.
	 *
	 * @return     returns boolean value.
	 */
	public boolean percolates() {
		return ufObject.connected(gridSize, gridSize + 1);
	}
}
/**.
 * the main class to implement the percolation method.
 */
public final class Solution {
	/**.
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**.
	 * main method to perform the operations.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		Percolation objPercolate = new Percolation(size);
		while (scan.hasNext()) {
			String[] items = scan.nextLine().split(" ");
			objPercolate.open(Integer.parseInt(
			                      items[0]) - 1, Integer.parseInt(
			                      items[1]) - 1);
		}
		System.out.println(objPercolate.percolates());


	}
}

