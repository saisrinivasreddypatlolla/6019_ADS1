import java.util.*;
class StudentDetails {
	Integer rollNumber;
	String name;
	Double totalMarks;
	StudentDetails(Integer roll, String name1, Double marks) {
		this.rollNumber = roll;
		this.name = name1;
		this.totalMarks = marks;
	}
	public Integer getRoll() {
		return this.rollNumber;
	}
	public String getName() {
		return this.name;
	}
	public Double getMarks() {
		return this.totalMarks;
	}
}
class Solution {
	public static void main(String[] args) {
		BST<Double, String> obj = new BST<Double, String>();
		Scanner scan = new Scanner(System.in);
		int inputs = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inputs; i++) {
			String[] tokens = scan.nextLine().split(",");
			obj.put(Double.parseDouble(tokens[2]), tokens[1]);
		}
		int values = Integer.parseInt(scan.nextLine());
		for (int j = 0; j < values; j++) {
			String[] tokens1 = scan.nextLine().split(",");
			if (tokens1[0].equals("BE")) {
				String[] keys = obj.keys(Double.parseDouble(tokens1[1]),Double.parseDouble(tokens1[2])).toString().split(" ");
				for(int i = 0;i<keys.length;i++){
					System.out.println(obj.get(Double.parseDouble(keys[i])));
				}
				System.out.println(Arrays.toString(keys));


			}
		}
	}
}