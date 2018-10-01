import java.util.Scanner;
class Solution{
	Solution(){

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList obj = new LinkedList();
		int values = scan.nextInt();
		while(scan.hasNext()){
			String[] tokens = scan.nextLine().split(" ");
			if(tokens==null){
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