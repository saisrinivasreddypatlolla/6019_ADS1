import java.util.Scanner;
/**.
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**.
     * This variable is for the sum of the cubes of
     * two numbers.
     */
    private final int sum;
    /**.
     * This variable is the first number.
     */
    private final int first;
    /**.
     * this variable is the second number
     */
    private final int second;
    /**.
     * Constructs the object.
     *
     * @param      first1     the first number
     * @param      second1     the second number
     */
    CubeSum(final int first1, final int second1) {
        this.sum = first1 * first1 * first1
                   + second1 * second1 * second1;
        this.first = first1;
        this.second = second1;
    }
    /**.
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return this.sum;
    }
    /**.
     * Gets the first.
     *
     * @return     The first.
     */
    public int getFirst() {
        return this.first;
    }
    /**.
     * Gets the second.
     *
     * @return     The second.
     */
    public int getSecond() {
        return this.second;
    }
    /**.
     * This method compares both sums
     *
     * @param      that  The that
     *
     * @return     returns the integer value after
     *             comparision
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }

        return 0;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + first + "^3" + " + " + second + "^3";
    }



}
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * input numbers limit
     */
    static final int INPUT = 600;
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * Main method to print the Nth number of M times of combinitions
     * Time complexity of method is O(2N)
     * first it will add all elements into minPQ
     * and the while loop checks until we find Nth ramanujan number
     * of M combinitions.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        int count = 0;
        int number = Integer.parseInt(tokens[0]);
        int times = Integer.parseInt(tokens[1]);
        int temp = -1;

        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= INPUT; i++) {
            pq.insert(new CubeSum(i, i));
        }

        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (temp == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == times - 1) {
                number--;
                if (number == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }

            temp = s.getSum();
            if (s.getSecond() < INPUT) {
                pq.insert(new CubeSum(
                              s.getFirst(), s.getSecond() + 1));
            }
        }
    }

}
