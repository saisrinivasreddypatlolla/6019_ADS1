import java.util.Scanner;
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			try {
				switch (tokens[0]) {
				case "insertAt":
					obj.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
					obj.print();
					break;
				case "reverse":
					obj.reverse();
					obj.print();
					break;

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}
}
class LinkedList {
	class Node {
		int item;
		Node next;
		Node(int item1) {
			this.item = item1;
		}
		public int getItem() {
			return this.item;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next1) {
			this.next = next1;
		}
	}
	private int size = 0;
	Node head = null;
	public void insertAt(int index, int item)throws Exception {
		if (index > size || index < 0) {
			throw new Exception("Can't insert at this position.");
		}
		Node temp = new Node(item);
		head = insertAt(head, temp, index, 0);
		size++;

	}
	private Node insertAt(Node current, Node temp, int index, int count) {
		if (head == null) {
			return temp;
		}
		if (count == index) {
			temp.next = current;
			return temp;
		}
		current.next = insertAt(current.next, temp, index, count + 1);
		return current;
	}
	public void reverse() throws Exception {
		if (head == null) {
			throw new Exception("No elements to reverse.");
		}
		reverse(head, null);
	}
	private void reverse(Node current, Node prev) {
		if (current.next == null) {
			head = current;
			head.next = prev;
			return;
		}
		Node temp = current.getNext();
		current.next = prev;
		reverse(temp, current);
	}
	// public void print() {
	// 	Node obj = head;
	// 	// if (head == null) {
	// 	// 	System.out.println("Steque is empty.");
	// 	// 	return;
	// 	// }
	// 	while (obj.getNext() != null) {
	// 		System.out.print(obj.item + ", ");
	// 		obj = obj.getNext();
	// 	} System.out.print(obj.item);
	// 	System.out.println();
	// }
	public void print(){
		Node curr = head;
		String result = "";
		while (curr != null) {
			if (curr.next == null) {
				result += curr.item;
			} else {
				result += curr.item + ", ";
			}
			curr = curr.next;
		}

		System.out.println(result);
	}
}