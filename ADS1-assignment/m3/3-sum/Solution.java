import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for three sum.
 */
class ThreeSum {
    /**.
     * variables to store input values
     */
    private int[] array;
    /**.
     * count of three sum numbers
     */
    private int count = 0;
    /**.
     * size of array
     */
    private int size = 0;
    /**
     * Constructs to assign array size.
     *
     * @param      sizes  The sizes
     */
    ThreeSum(final int sizes) {
        array = new int[sizes];
    }
    /**.
     * thismethod adds the values to the array.
     *
     * @param      element  The element
     */
    public void add(final int element) {
        array[size++] = element;
    }
    /**.
     * this method is used to find the count
     * of three sum.
     */
    public void threeSum() {
        Arrays.sort(array);
        int i, j, k;
        for (i = 0; i < size - 1; i++) {
            j = i + 1;
            k = size - 1;
            while (k > j) {
                if (array[i] + array[j] + array[k] < 0) {
                    j++;
                } else if (array[i] + array[j] + array[k] > 0) {
                    k--;
                } else {
                    count++;
                    j++;
                    k--;
                }
            }
        }
        System.out.println(count);
    }
}
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * this method is used to take inputs
     * and perform operations.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = scan.nextInt();
        ThreeSum obj = new ThreeSum(inputs);
        for (int i = 0; i < inputs; i++) {
            obj.add(scan.nextInt());
        }
        obj.threeSum();
    }
}
