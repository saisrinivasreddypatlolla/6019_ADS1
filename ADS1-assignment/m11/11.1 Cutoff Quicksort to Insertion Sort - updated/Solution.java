import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for insertion sort.
 */
class InsertionSort {
    /**
     * Constructs the object.
     */
    InsertionSort() {

    }

    /**
     * sort Array of elements of low array length.
     *
     * @param      array     the array
     * @param      low    The lower
     * @param      high    The higher
     *
     * @return     returns the sorted array.
     */
    public Comparable[] insertionSort(final Comparable[] array,
                                      final int low, final int high) {
        return sort(array, low, high);
    }

    /**
     * private Method to Sort Array of elements using Insertion Sort.
     * The Complexity of Insertion Sort is O(N^2)
     * It has two loops for comparing and swapping the elements
     * For this the worst case complexity is O(N^2)
     *
     * @param      array     { Array elements to Sort }
     * @param      low    The lower
     * @param      high    The higher
     *
     * @return     returns sorted array
     */
    private Comparable[] sort(final Comparable[] array,
                              final  int low, final int high) {
        int j = 0;
        for (int i = low + 1; i <= high; i++) {
            j = i - 1;
            Comparable temp = array[i];
            while (j >= 0 && temp.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}

/**
 * Class for quick sort.
 */
class QuickSort {
    /**
     * Cutoff Specified by User.
     */
    private int cutoff;
    /**
     * Object for insertion Sort Class.
     */
    private InsertionSort insertion;
    /**
     * Constructs the object.
     *
     * @param      cut   The cut
     */
    QuickSort(final int cut) {
        cutoff = cut;
        insertion = new InsertionSort();
    }

    /**
     * Method to call Private Quick Sort Method.
     *
     * @param      array       Array to be Sorted
     */
    public void quickSort(final Comparable[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    /**
     * Method to Sort the elements using Quick Sort.
     * The complexity is O(N^2)
     * This is not Stable based upon pivot element selection.
     * It iterates two loops to find the pivot element and sort.
     *
     * @param      array     Array to be Sorted
     * @param      low    The lower
     * @param      high    The higher
     */
    private void quickSort(final Comparable[] array,
                           final int low, final int high) {
        if (high - low + 1 <= cutoff) {
            insertion.insertionSort(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(array, low, high);
        quickSort(array, low, j - 1);
        quickSort(array, j + 1, high);
    }

    /**
     * Partition the Array using Pivot Element.
     *
     * @param      array     Array to be Sorted
     * @param      low    The lower
     * @param      high    The higher
     *
     * @return     Index of the Paartitioned element in Array
     */
    private int partition(final Comparable[] array,
                          final int low, final int high) {
        int i = low + 1;
        int k = low;
        int j = high;
        while (true) {
            while (less(array[i], array[k])) {
                i++;
                if (i == high) {
                    break;
                }
            }
            while (less(array[k], array[j])) {
                j--;
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(array, i, j);
            i++;
        }
        exchange(array, j, k);
        System.out.println(Arrays.toString(array));
        return j;
    }

    /**
     * Less method to Compare the Less one.
     *
     * @param      objOne     Object Comparable 1
     * @param      objTwo     Object Comparable 2
     *
     * @return     True or False based upon less value than 0.
     */
    private boolean less(final Comparable objOne, final Comparable objTwo) {
        return objOne.compareTo(objTwo) < 0;
    }

    /**
     * Exchange method swap the elements in the Array.
     *
     * @param      array     { Array of comparable type. }
     * @param      i     { index of element to be Swapped }
     * @param      k     { index of second element to be swapped }
     */
    private void exchange(final Comparable[] array, final int i, final int k) {
        Comparable temp = array[k];
        array[k] = array[i];
        array[i] = temp;
    }
}

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
     * Main Method to Sort the Elements using Quick Sort.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (num > 0) {
            int cutoff = scan.nextInt();
            scan.nextLine();
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].length() == 0) {
                System.out.println("[]");
            } else {
                QuickSort quick = new QuickSort(cutoff);
                quick.quickSort(tokens);
                System.out.println(Arrays.toString(tokens));
            }
            num--;
        }
    }
}
