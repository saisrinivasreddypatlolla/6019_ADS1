import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    Solution() {

    }
    /**.
     * the main function to perform operations.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList obj = new LinkedList();
        int values = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            if (line.length() == 0) {
                obj.setSize(0);
                System.out.println();
            } else {
                switch (tokens[0]) {
                case "push":
                    obj.addStart(Integer.parseInt(
                                     tokens[1]));
                    obj.print();
                    break;
                case "pop":
                    obj.removeStart();
                    obj.print();
                    break;
                case "enqueue":
                    obj.addEnd(Integer.parseInt(tokens[1]));
                    obj.print();
                    break;
                default:
                    break;
                }
            }
        }
    }
}