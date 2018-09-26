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
     * @param      sizes  The size
     */
    ThreeSum(final int sizes) {
        array = new int[size];
    }
    /**.
     * thismethod adds the values to the array.
     *
     * @param      element  The element
     */
    public void add(final int element) {
        array[size++] = element;
    }
    // public void threeSum() {
    //  Arrays.sort(array);
    //  for (int i = 0; i < size - 1; i++) {
    //      for (int j = i + 1; j < size - 1; j++) {
    //          int k = Arrays.binarySearch(
    //              array, -(array[i] + array[j]));
    //          if (k > j) {
    //StdOut.println(a[i] + " " + a[j] + " " + a[k]);
    //              count++;
    //          }
    //      }
    //  }
    //  System.out.println(count);
    // }
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
    // public void threeSum() {
    //  int cc = 0;
    //  for (int i = 0; i < array.length; i++) {
    //      for (int j = i + 1; j < array.length; j++) {
    // // int k = Arrays.binarySearch(array, -(array[i]+array[j]));
    //          for (int k = j + 1; k < array.length; k++) {
    //              if (array[i]+array[j]+array[k]==0) {
    //                  count++;
    // System.out.println("***"+array[i]+", "+array[j]+", "+array[k]);
    //              }
    // System.out.println(array[i]+", "+array[j]+", "+array[k]);
    //              cc++;
    //          }

    //      }
    //  }
    //  System.out.println(count);
    //  System.out.println("cc = "+cc);
    // }
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
     * { function_description }
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