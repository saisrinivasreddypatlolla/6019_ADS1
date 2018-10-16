import java.util.Scanner;
/**.
 * Class for median finding.
 */
class MedianFinding {
    /**.
     * creating an object for MinPQ class
     */
    private MinPQ<Double> minObj;
    /**.
     * creating an object for MaxPQ class
     */
    private MaxPQ<Double> maxObj;
    /**.
     * Constructs the object.
     */
    MedianFinding() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    /**.
     * this method inserts element into minheap.
     * Time complexity of this method is O(N)
     * it will insert at last position and calls
     * swim method.
     *
     * @param      item  The item
     */
    public void minInsert(final Double item) {
        minObj.insert(item);
    }
    /**.
     * this method inserts element into maxheap.
     * Time complexity of this method is O(N)
     * it will insert at last position and calls
     * swim method.
     *
     * @param      item  The item
     */
    public void maxInsert(final Double item) {
        maxObj.insert(item);
    }
    /**.
     * Gets the minimum element from minheap.
     * Time complexity is O(1)
     * returns the top element min pq.
     *
     * @return     The minimum element from minheap.
     */
    public Double getMin() {
        return minObj.min();
    }
    /**.
     * Gets the maximum element from maxheap.
     * Time complexity is O(1)
     * returns the top element max pq.
     *
     * @return     The maximum element from maxheap.
     */
    public Double getMax() {
        return maxObj.max();
    }
    /**.
     * this method deletes the min element from minheap
     * Time complexity is O(1)
     * returns the top element min pq.
     *
     * @return     returns the deleted element from minheap
     */
    public Double delMin() {
        return minObj.delMin();
    }
    /**.
     * this method deletes the max element from maxheap
     * Time complexity is O(1)
     * returns the top element min pq.
     *
     * @return     returns the deleted element from maxheap
     */
    public Double delMax() {
        return maxObj.delMax();
    }
    /**.
     * Gets the size of maxheap.
     * Time complexity is O(1)
     * returns the size of min pq.
     *
     * @return     the size of maxheap.
     */
    public int getMaxSize() {
        return maxObj.size();
    }
    /**.
     * the size of minheap
     * Time complexity is O(1)
     * returns the size of max pq.
     *
     * @return     the size of minheap.
     */
    public int getMinSize() {
        return minObj.size();
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
     * main method is used to perform the operations
     * Time complexity of this method is O(N).
     * N is the number of inputs.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        MedianFinding obj = new MedianFinding();
        int lines = Integer.parseInt(scan.nextLine());
        Double value = Double.parseDouble(scan.nextLine());
        Double median = value;
        obj.minInsert(value);
        System.out.println(median);
        for (int i = 1; i < lines; i++) {
            value = Double.parseDouble(scan.nextLine());
            if (value >= median) {
                obj.minInsert(value);
            } else {
                obj.maxInsert(value);
            }
            if (obj.getMinSize() - obj.getMaxSize() > 1) {
                obj.maxInsert(obj.delMin());
            }
            if (obj.getMaxSize() - obj.getMinSize() > 1) {
                obj.minInsert(obj.delMax());
            }
            if (Math.abs(obj.getMaxSize() - obj.getMinSize()) == 1) {
                if (obj.getMinSize() > obj.getMaxSize()) {
                    median = obj.getMin();
                    System.out.println(median);
                } else {
                    median = obj.getMax();
                    System.out.println(median);
                }
            }
            if (obj.getMinSize() == obj.getMaxSize()) {
                median = (obj.getMin() + obj.getMax()) / 2.0;
                System.out.println(median);
            }
        }
    }
}
