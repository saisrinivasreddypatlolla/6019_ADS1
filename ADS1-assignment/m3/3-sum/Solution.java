import java.util.*;
class ThreeSum {
	int[] array;
	int size = 0;
	int count = 0;
	ThreeSum(int size) {
		array = new int[size];
	}
	public void add(int element) {
		array[size++] = element;
	}
	public void threeSum(){
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                int k = Arrays.binarySearch(array, -(array[i] + array[j]));
                if (k > j){
                 // StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                	count++;
                }
            }
        }
        System.out.println(count);
	}
	// public void threeSum() {
	// 	int cc = 0;
	// 	for (int i = 0; i < array.length; i++) {
	// 		for (int j = i + 1; j < array.length; j++) {
	// 			// int k = Arrays.binarySearch(array, -(array[i]+array[j]));
	// 			for (int k = j + 1; k < array.length; k++) {
	// 				if (array[i]+array[j]+array[k]==0) {
	// 					count++;
	// 					System.out.println("***"+array[i]+", "+array[j]+", "+array[k]);
	// 				}
	// 				System.out.println(array[i]+", "+array[j]+", "+array[k]);
	// 				cc++;
	// 			}

	// 		}
	// 	}
	// 	System.out.println(count);
	// 	System.out.println("cc = "+cc);
	// }
	// public void threeSum() {
	// 	int cc = 0;
	// 	int temp1, temp2, k = 0;

	// 	for (int i = 0; i < array.length - 1; i++) {
	// 		temp1 = array[k];
	// 		temp2 = array[i + 1];
	// 		for (int j = i + 2; j < array.length; j++) {
	// 			if (temp1 + temp2 + array[j] == 0) {
	// 				count++;
	// 			}
	// 			System.out.println(array[i] + ", " + array[j] + ", " + array[k]);
	// 			cc++;

	// 		}
	// 	}
	// 	System.out.println(count);
	// 	System.out.println("cc = " + cc);
	// }
	private static boolean containsDuplicates(int[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] == a[i - 1]) return true;
		return false;
	}

}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputs = scan.nextInt();
		ThreeSum obj = new ThreeSum(inputs);
		for (int i = 0; i < inputs; i++) {
			obj.add(scan.nextInt());
		}
		obj.threeSum();
	}
}