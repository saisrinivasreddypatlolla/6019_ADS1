import java.util.Scanner;
class MedianFinding {
	MinPQ<Double> minObj;
	MaxPQ<Double> maxObj;
	MedianFinding() {
		minObj = new MinPQ<Double>();
		maxObj = new MaxPQ<Double>();
	}
	public void minInsert(Double item) {
		minObj.insert(item);
	}
	public void maxInsert(Double item) {
		maxObj.insert(item);
	}
	public Double getMin() {
		return minObj.min();
	}
	public Double getMax(){
		return maxObj.max();
	}
	public Double delMin(){
		return minObj.delMin();
	}
	public Double delMax(){
		return maxObj.delMax();
	}
	public int getMaxSize(){
		return maxObj.size();
	}
	public int getMinSize(){
		return minObj.size();
	}
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MedianFinding obj = new MedianFinding();
		int lines = Integer.parseInt(scan.nextLine());
		Double value = Double.parseDouble(scan.nextLine());
		Double median = value;
		obj.minInsert(value);
		System.out.println(median);
		for(int i = 1;i<lines;i++){
			value = Double.parseDouble(scan.nextLine());
			if(value>=median){
				obj.minInsert(value);
			} else{
				obj.maxInsert(value);
			}
			if(obj.getMinSize()-obj.getMaxSize()>1){
				obj.maxInsert(obj.delMin());
			}
			if(obj.getMaxSize()-obj.getMinSize()>1){
				obj.minInsert(obj.delMax());
			}
			if(Math.abs(obj.getMaxSize()-obj.getMinSize())==1){
				if(obj.getMinSize()>obj.getMinSize()){
					median = obj.getMin();
					System.out.println(median);
				} else{
					median = obj.getMax();
					System.out.println(median);
				}
			}
			if(obj.getMinSize()==obj.getMaxSize()){
				median = (obj.getMin()+obj.getMax())/2.0;
				System.out.println(median);
			}
		}
	}
}