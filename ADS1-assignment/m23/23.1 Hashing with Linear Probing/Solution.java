import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main method to perform operations.
     * Time complexity of this method
     * O(M(logN*+logN*+logN*))
     * M is the number of inputs
     * 1st logN* is for put method
     * 2nd logN* is for get method
     * 3rd logN* is for delete method
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        LinearProbingHashST<String, Integer> obj
         = new LinearProbingHashST<>();
        for (int i = 0; i <= num; i++) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
                case "put": obj.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
                case "display":
                    if (obj.size() == 0) {
                    System.out.println("{}");
                } else {
                    String str = "";
                    for (String str1: obj.keys()) {
                        str += str1 + ":" + obj.get(str1) + ", ";
                    }
                    System.out.println("{" + str.substring(
                        0, str.length() - 2) + "}");
                }
                break;
                case "delete":
                obj.delete(tokens[1]);
                break;
                case "get":
                System.out.println(obj.get(tokens[1]));
                break;
                default:
                break;
            }
        }
    }
}
