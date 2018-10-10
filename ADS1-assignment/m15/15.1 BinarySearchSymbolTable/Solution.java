import java.util.Arrays;
import java.util.Scanner;
/**.
 * Class for binary search symbol table.
 *
 * @param      <Keys>    The keys
 * @param      <Values>  The values
 */
class BinarySearchST<Keys extends Comparable<Keys>, Values> {
    /**.
     * this array is to stor the keys
     */
    private Keys[] keys;
    /**.
     * this array is to store the values
     */
    private Values[] values;
    /**.
     * this variable stores the size of
     * binary search symbol table.
     */
    private int size;
    /**.
     * this constructor is used to
     * initialize the array size and size variable.
     */
    BinarySearchST() {
        final int ten = 10;
        keys = (Keys[]) new Comparable[ten];
        values = (Values[]) new Comparable[ten];
        size = 0;
    }
    /**
     * this method used to resize the arrays.
     * Time complexity of this method is O(1)
     */
    private void resize() {
        keys = Arrays.copyOf(keys, size + 1);
        values = Arrays.copyOf(values, size + 1);
    }
    /**
     * this method stores the key in keys array and
     * value in value array.
     * Time complexity of this method is O(logN)
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Keys key, final Values value) {
        if (size == keys.length) {
            resize();
        }
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
            size++;
            return;
        }
        int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }
        for (int i = size; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        size++;
    }
    /**.
     * this method returns the key's rank.
     * Time complexity of this method is O(logN)
     *
     * @param      key   The key
     *
     * @return     returns the key's rank.
     */
    public int rank(final Keys key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                high = mid - 1;
            } else if (key.compareTo(keys[mid]) > 0) {
                low = mid + 1;
            } else {
                return mid;
            }


        }
        return low;

    }
    /**.
     * this method deletes that key from keys array
     * and value from the values array.
     * Time complexity of this method is O(logN)
     *
     * @param      key   The key
     */
    public void delete(final Keys key) {
        int rank = rank(key);
        for (int i = rank; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
    }
    /**.
     * this method returns the size of binary search symbol table.
     * Time complexity of this method is O(1)
     *
     * @return     returns the size of binary search symbol table.
     */
    public int size() {
        return size;
    }
    /**.
     * Determines if empty.
     * Time complexity of this method is O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**.
     * this method returns true if the key is in
     * symbol table else false.
     * Time complexity of this method is O(1)
     *
     * @param      key   The key
     *
     * @return     returns true if the key is in
     *             symbol table else false.
     */
    public boolean contains(final Keys key) {
        return get(key) != null;
    }
    /**.
     * this method returns the value of particular key.
     * Time complexity of this method is O(1)
     *
     * @param      key   The key
     *
     * @return     returns the value of particular key.
     */
    public Values get(final Keys key) {
        if (isEmpty()) {
            return null;
        }
        int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            return values[rank];
        }
        return null;
    }
    /**.
     * deletes minimum element in the keys array.
     * Time complexity of this method is O(1)
     */
    public void deleteMin() {
        delete(min());
    }
    /**.
     * deletes the maximum elements in the keys array
     * Time complexity of this method is O(1)
     */
    public void deleteMax() {
        delete(max());
    }
    /**.
     * this method returns the minimum key in the keys array
     * Time complexity of this method is O(1)
     *
     * @return     returns the minimum key in the keys array
     */
    public Keys min() {
        return keys[0];
    }
    /**.
     * this method returns the maximum key in the keys array
     * Time complexity of this method is O(1)
     *
     * @return     returns the maximum key in the keys array
     */
    public Keys max() {
        return keys[size - 1];
    }
    /**.
     * this method returns the key in that index of keys array.
     * Time complexity of this method is O(1)
     *
     * @param      index  The index
     *
     * @return     returns the key in that index of keys array.
     */
    public Keys select(final int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return keys[index];
    }
    /**.
     * this method returns the key which is equal to the element
     * in keys array
     * else returns the largest element
     * Time complexity of this method is O(logN)
     *
     * @param      key   The key
     *
     * @return     returns the key
     */
    public Keys floor(final Keys key) {
        int rank = rank(key);
        if (rank <= 0) {
            return null;
        }
        if ((rank < size) && (key.compareTo(keys[rank])) == 0) {
            return keys[rank];
        }
        return keys[rank - 1];
    }
    /**.
     * this method returns the key which is equal to the element
     * in keys array
     * else returns the smallest element
     * Time complexity of this method is O(logN)
     *
     * @param      key   The key
     *
     * @return     returns the key
     */
    public Keys ceiling(final Keys key) {
        int rank = rank(key);
        return keys[rank];
    }
    /**.
     * prints all the keys in keys array with values of that keys.
     * Time complexity of this method is O(N)
     */
    public void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
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
    /**
     * this method perform operations.
     * Time complexity of this method is O(N)
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BinarySearchST<String, Integer> obj = new BinarySearchST<>();
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            obj.put(tokens[i], i);
        }
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]) {
            case "deleteMin":
                obj.deleteMin();
                break;
            case "deleteMax":
                obj.deleteMax();
                break;
            case "max":
                System.out.println(obj.max());
                break;
            case "min":
                System.out.println(obj.min());
                break;
            case "rank":
                System.out.println(obj.rank(input[1]));
                break;
            case "contains":
                System.out.println(obj.contains(input[1]));
                break;
            case "get":
                System.out.println(obj.get(input[1]));
                break;
            case "keys":
                obj.keys();
                break;
            case "floor":
                System.out.println(obj.floor(input[1]));
                break;
            case "ceiling":
                System.out.println(obj.ceiling(input[1]));
                break;
            default:
                break;
            }
        }
    }
}
