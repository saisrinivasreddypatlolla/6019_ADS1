import java.util.Scanner;
/**
 * Class for student details.
 */
class StudentDetails {
    /**
     * roll number of student.
     */
    private Integer rollNumber;
    /**
     * name of student.
     */
    private String name;
    /**
     * Constructs the object.
     *
     * @param      roll   The roll number of student
     * @param      name1  The name of student.
     */
    StudentDetails(final Integer roll, final String name1) {
        this.rollNumber = roll;
        this.name = name1;
    }
    /**
     * Gets the roll.
     *
     * @return     The roll number.
     */
    public Integer getRoll() {
        return this.rollNumber;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to perform operations.
     * Time complexity of this method is MlogN+PlogQ
     * M is the number of studet details
     * logN is the insertion in BST
     * P is the number of queries
     * logQ is the nnumber of values to be printed.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        BST<Double, StudentDetails> obj = new BST <
        Double, StudentDetails > ();
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < inputs; i++) {
            String[] tokens = scan.nextLine().split(",");
            obj.put(Double.parseDouble(
                        tokens[2]), new StudentDetails(
                        Integer.parseInt(tokens[0]), tokens[1]));
        }
        int values = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < values; j++) {
            String[] tokens1 = scan.nextLine().split(" ");
            if (tokens1[0].equals("BE")) {
                String[] keys = obj.keys(
                                    Double.parseDouble(
                                        tokens1[1]), Double.parseDouble(
                                        tokens1[2])).toString().split(" ");
                for (int i = 0; i < keys.length; i++) {
                    System.out.println(obj.get(
                                           Double.parseDouble(keys[i])).getName());
                }


            } else if (tokens1[1].equals("LE")) {
                Double min = obj.min();
                String[] lessKeys = obj.keys(
                                        min, Double.parseDouble(
                                            tokens1[1])).toString().split(" ");
                for (int i = 0; i < lessKeys.length; i++) {
                    System.out.println(obj.get(
                                           Double.parseDouble(
                                               lessKeys[i])).getName());
                }

            } else if (tokens1[1].equals("GE")) {
                Double max = obj.max();
                String[] gretKeys = obj.keys(
                                        Double.parseDouble(
                                            tokens1[1]), max).toString().split(" ");
                for (int i = 0; i < gretKeys.length; i++) {
                    System.out.println(
                        obj.get(Double.parseDouble(
                                    gretKeys[i])).getName());
                }

            }
        }
    }
}