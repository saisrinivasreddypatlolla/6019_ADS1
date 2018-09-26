import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		int[] array = {2, 2, 2, 2, 2, 1, 1};
		int i, j, count = 0, count1 = 0;
		Arrays.sort(array);
		for (i = 0; i < array.length - 1; i++) {
			j = i + 1;
			if (array[i] == array[j]) {
				count++;
			}
			if (i == array.length - 2 || array[i] != array[j]) {
				count1 += ((count+1) * count) / 2;
				count = 0;
			}
		}
		System.out.print(count1);
	}
}