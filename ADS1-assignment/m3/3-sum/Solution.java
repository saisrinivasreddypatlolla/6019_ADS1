import java.util.*;
class ThreeSum{
	int[] array;
	int size=0;
	int count=0;
	ThreeSum(int size){
		array = new int[size];
	}
	public void add(int element){
		array[size++] = element;
	}
	public void threeSum(){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				for(int k=j+1;k<array.length;k++){
					if(array[i]+array[j]+array[k]==0){
						count++;
						break;
					}
				}
			}
		}
		System.out.println(count);
	}

}
class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputs = scan.nextInt();
		ThreeSum obj = new ThreeSum(inputs);
		for(int i=0;i<inputs;i++){
			obj.add(scan.nextInt());
		}
		obj.threeSum();
	}
}