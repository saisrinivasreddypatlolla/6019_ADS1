import java.util.Scanner;
import java.util.Arrays;
class Solution{
	Solution(){

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList obj = new LinkedList();
		int values = scan.nextInt();
		scan.nextLine();
		while(scan.hasNext()){
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			// System.out.println(Arrays.toString(tokens)+" "+tokens==null);
			if(line.length()==0){
				// System.out.println("hello");
				obj.setSize(0);
				System.out.println();
			}else{
				switch(tokens[0]){
				case "push":
					obj.addStart(Integer.parseInt(tokens[1]));
					obj.print();
					break;
				case "pop":
					obj.removeStart();
					obj.print();
					break;
				case "enqueue":
					obj.addEnd(Integer.parseInt(tokens[1]));
					obj.print();
					break;
				default:
					break;
				}
			}
		}
	}
}