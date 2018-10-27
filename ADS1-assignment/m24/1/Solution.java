import java.util.Scanner;
/**
 * Solution class to perform operations.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * the main method to perform opertions.
     * Time complexity of this method is
     * O(MlogN*+PlogN*)
     * M is the number of times put method called
     * logN* is the put method time complexity for N values
     * P is te number of times get method called
     * logN* is the get method time complexity for N values
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinearProbingHashST<Integer, String> obj =
            new LinearProbingHashST<Integer, String>();
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < inputs; i++) {
            String[] tokens = scan.nextLine().split(",");
            String s = tokens[1] + "," + tokens[2];
            obj.put(Integer.parseInt(tokens[0]), s);
        }
        int values = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < values; j++) {
            String[] tokens1 = scan.nextLine().split(" ");
            String s = obj.get(Integer.parseInt(tokens1[1]));
            if (s != null) {
                String[] tokens2 = s.split(",");
                if (Integer.parseInt(tokens1[2]) == 1) {
                    System.out.println(tokens2[0]);
                } else {
                    System.out.println(
                        Double.parseDouble(tokens2[1]));
                }
            } else {
                System.out.println("Student doesn't exists...");
            }
        }
    }

}
