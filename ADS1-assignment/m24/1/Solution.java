import java.util.Scanner;
final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		LinearProbingHashST<Integer, String> st =
		    new LinearProbingHashST<Integer, String>();
		Scanner scan = new Scanner(System.in);
		int inputs = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inputs; i++) {
			String[] tokens = scan.nextLine().split(",");
			String s = tokens[1] + "," + tokens[2];
			st.put(Integer.parseInt(tokens[0]), s);
		}
		int values = Integer.parseInt(scan.nextLine());
		for (int j = 0; j < values; j++) {
			String[] tokens1 = scan.nextLine().split(" ");
			String s = st.get(Integer.parseInt(tokens1[1]));
			if (s != null) {
				String[] tokens2 = s.split(",");
				if (Integer.parseInt(tokens1[2]) == 1) {
					System.out.println(tokens2[0]);
				} else {
					System.out.println(Double.parseDouble(tokens2[1]));
				}
			} else {
				System.out.println("Student doesn't exists...");
			}
		}
	}

}
