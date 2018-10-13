import java.util.Arrays;
import java.util.Scanner;
class StockDetails implements Comparable<StockDetails>{
    String stockName;
    Double percentChange;
    StockDetails(String name, Double perChange){
        this.stockName = name;
        this.percentChange = perChange;
    }
    public void setPerChange(Double value){
        this.percentChange = value;
    }
    public String getName(){
        return this.stockName;
    }
    public Double getPerChange(){
        return this.percentChange;
    }
    public int compareTo(StockDetails obj){
        if(this.percentChange<obj.percentChange){
            return -1;
        } else if(this.percentChange>obj.percentChange){
            return 1;
        }
        return this.stockName.compareTo(obj.stockName);
    }
    public String toString(){
        return this.stockName+" "+percentChange;
    }
}
final class Solution{
    private Solution(){

    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        BinarySearchST<String,  Integer> maxObj =
            new BinarySearchST<String, Integer>();
        BinarySearchST<String, Integer> minObj =
            new BinarySearchST<String, Integer>();

        for (int i = 0; i < 6; i++) {
            MinPQ<StockDetails> minPQ = new MinPQ<StockDetails>();
            MaxPQ<StockDetails> maxPQ = new MaxPQ<StockDetails>();

            for (int j = 0; j < inputs; j++) {
                String[] tokens = scan.nextLine().split(",");
                StockDetails obj = new StockDetails(tokens[0],
                                        Double.parseDouble(tokens[1]));
                minPQ.insert(obj);
                maxPQ.insert(obj);
            }

            for (int k = 0; k < 5; k++) {
                StockDetails key = maxPQ.delMax();
                Integer value = maxObj.get(key.getName());
                if (value != null) {
                    maxObj.put(key.getName(), value + 1);
                } else {
                    maxObj.put(key.getName(), 1);
                }
                System.out.println(key);
            }
            System.out.println();
            for (int k = 0; k < 5; k++) {
                StockDetails key = minPQ.delMin();
                Integer value = minObj.get(key.getName());
                if (value != null) {
                    minObj.put(key.getName(), value + 1);
                } else {
                    minObj.put(key.getName(), 1);
                }
                System.out.println(key);
            }
            System.out.println();
        }

        int queries = scan.nextInt();
        if (queries == 0) {
            return;
        }

        scan.nextLine();

        for (int i = 0; i < queries; i++) {
            String[] tokens = scan.nextLine().split(",");
            if (tokens[0].equals("get")) {
                if (tokens[1].equals("minST")) {
                    Integer freq = minObj.get(tokens[2]);
                    if (freq != null) {
                        System.out.println(freq);
                    } else {
                        System.out.println(0);
                    }
                } else {
                    Integer freq = maxObj.get(tokens[2]);
                    if (freq != null) {
                        System.out.println(freq);
                    } else {
                        System.out.println(0);
                    }
                }
            } 

        }

    }
}