import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * returns the int array for a string.
     *
     * @param      s     string parameter
     *
     * @return     returns the int array for a string
     */
    public static int[] intArray(final String s) {
        String[] inputs = s.split(",");
        int[] array = new int[inputs.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(inputs[i]);
        }
        return array;
        // return Arrays.stream(s.split(","))
        // .mapToInt(Integer::parseInt)
        // .toArray();
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int[]arrayOne = new int[scan.nextInt()];
        int[]arrayTwo = new int[scan.nextInt()];
        if (arrayOne.length != 0) {
            arrayOne = intArray(scan.next());
        }
        if (arrayTwo.length != 0) {
            arrayTwo = intArray(scan.next());
        }
        int[] outputArray = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0, k = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                outputArray[k++] = arrayOne[i];
                i = i + 1;
            } else if (arrayOne[i] > arrayTwo[j]) {
                outputArray[k++] = arrayTwo[j];
                j = j + 1;
            }
        }
        if (arrayOne.length > arrayTwo.length) {
            while (k < arrayOne.length + arrayTwo.length) {
                outputArray[k++] = arrayOne[i++];
            }

        }
        if (arrayTwo.length > arrayOne.length) {
            while (k < arrayOne.length + arrayTwo.length) {
                outputArray[k++] = arrayTwo[j++];
            }
        }
        System.out.println(Arrays.toString(outputArray).replace("[", "")
                           .replace("]", "").replace(" ", ""));
    }
}
