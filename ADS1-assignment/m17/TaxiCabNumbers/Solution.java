import java.util.Scanner;
class CubeSum implements Comparable<CubeSum> {
	private final int sum;
	private final int i;
	private final int j;

	public CubeSum(int i, int j) {
		this.sum = i * i * i + j * j * j;
		this.i = i;
		this.j = j;
	}
	public int getSum() {
		return this.sum;
	}
	public int getFirst() {
		return this.i;
	}
	public int getSecond() {
		return this.j;
	}

	public int compareTo(CubeSum that) {
		if (this.sum < that.sum) return -1;
		if (this.sum > that.sum) return +1;
		return 0;
	}

	public String toString() {
		return sum + " = " + i + "^3" + " + " + j + "^3";
	}



}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(" ");
		int count = 0;
		int N = Integer.parseInt(tokens[0]);
		int M = Integer.parseInt(tokens[1]);
		int n = 600;
		int temp = -1;

		// initialize priority queue
		MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
		for (int i = 0; i <= n; i++) {
			pq.insert(new CubeSum(i, i));
		}

		// find smallest sum, print it out, and update
		while (!pq.isEmpty()) {
			CubeSum s = pq.delMin();
			if (temp == s.getSum()) {
				count++;
			} else {
				count = 0;
			}
			if (count == M - 1) {
				N--;
				if (N == 0) {
					System.out.println(s.getSum());
					break;
				}
			}

			temp = s.getSum();
			if (s.getSecond() < n)
				pq.insert(new CubeSum(s.getFirst(), s.getSecond() + 1));
		}
	}

}