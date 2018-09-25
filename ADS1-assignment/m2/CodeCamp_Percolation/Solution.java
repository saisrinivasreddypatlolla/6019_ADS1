import java.util.Scanner;
import java.util.Arrays;
class Percolation {
	boolean[] matrix;
	int size, gridSize, count = 0;
	WeightedQuickUnionUF uf;
	public Percolation(int n) {
		matrix = new boolean[(n * n) + 2];
		size = n;
		gridSize = n * n;
		uf = new WeightedQuickUnionUF(size * size + 2);
	}                // create n-by-n grid, with all sites blocke

	public void open(int row, int col) {
		if (!(isOpen(row, col))) {
			matrix[(row * size) + col] = true;
			count++;
			if (row - 1 >= 0 && isOpen(row - 1, col)) {
				uf.union(indexOf(row, col), indexOf(row - 1, col));
			}
			if (row + 1 < (size) && isOpen(row + 1, col)) {
				uf.union(indexOf(row, col), indexOf(row + 1, col));
			}
			if (col - 1 >= 0 && isOpen(row, col - 1)) {
				uf.union(indexOf(row, col), indexOf(row, col - 1));
			}
			if (col + 1 < (size) && isOpen(row, col + 1)) {
				uf.union(indexOf(row, col), indexOf(row, col + 1));
			}
			if (row == 0) {
				uf.union(row, gridSize);
			}
			if (row == size-1) {
				uf.union(row, gridSize + 1);
			}
		}
	}
	private int indexOf(int row, int col) {
		return (size * row) + col;
	}   // open site (row, col) if it is not open already
	public boolean isOpen(int row, int col) {
		// System.out.println(row + "---" + col);
		if (matrix[(row * size) + col] == false) {
			return false;
		}
		return true;
	}  // is site (row, col) open?
	// public boolean isFull(int row, int col)  // is site (row, col) full?
	public int numberOfOpenSites() {
		return count;
	}       // number of open sites
	public boolean percolates() {
		return uf.connected(gridSize, gridSize + 1);
	}           // does the system percolate?
}
public class Solution {
	public static void main(String[] args) {
		// Percolation p = new Percolation()
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		Percolation p = new Percolation(size);
		while (scan.hasNext()) {
			String[] items = scan.nextLine().split(" ");
			p.open(Integer.parseInt(items[0]) - 1, Integer.parseInt(items[1]) - 1);
		}
		System.out.println(p.percolates());


	}
}

// You can implement the above API to solve the problem