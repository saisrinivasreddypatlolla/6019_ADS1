class Node {
	int data;
	Node address;
	Node(int data1) {
		this.data = data1;

	}
	Node() {

	}
	public int getData() {
		return this.data;
	}
	public Node getAddress() {
		return this.address;
	}
	public void setAddress(Node address1) {
		this.address = address1;
	}
}
class LinkedList {
	int size = 0;
	Node head;
	Node tail;
	public void addStart(int item) {
		if (size == 0) {
			head = new Node(item);
			head.address = null;
			tail = head;
			size++;
			return;
		}
		Node temp = new Node(item);
		temp.address = head;
		head = temp;
		size++;
	}
	public void addEnd(int item) {
		if (size == 0) {
			head = new Node(item);
			tail = head;
			head.address = null;
			size++;
			return;
		}
		Node temp = new Node(item);
		temp.address = null;
		tail.address = temp;
		tail = temp;
		size++;
	}
	public void addElement(int element1, int item) {
		if (size == 0) {
			head = new Node(item);
			head.address = null;
			size++;
			return;
		}
		Node temp = new Node(item);
		Node obj = head;
		while (obj.data != element1) {
			obj = obj.getAddress();

		}
		temp.address = obj.address;
		obj.address = temp;
		size++;
	}
	public void addPosition(int index, int item) {
		if (index > size || index < 0) return;
		int counter = 0;
		Node temp = head;
		while (counter != index - 1) {
			temp = temp.getAddress();
			counter++;
		}
		Node obj = new Node(item);
		obj.address = temp.getAddress();
		temp.address = obj;
		size++;

	}
	public void removeStart() {
		if (head == null) return;
		if (size == 1) {
			head = null;
			size = 0;
			return;
		}
		head = head.address;
		size--;
	}
	public void removeEnd() {
		if (head == null) return;
		if (size == 1) {
			head = null;
			tail = null;
			size = 0;
			return;
		}
		Node temp = head;
		while (temp.address.address != null) {
			temp = temp.address;
		}
		temp.address = null;
		tail = temp;
		size--;
	}
	public void removeElement(int item) {
		if (head == null) return;
		if (size == 1) {
			head = null;
			tail = null;
			size = 0;
			return;
		}
		Node temp = head;
		while (temp.address.data != item) {
			temp = temp.getAddress();
		}
		if (temp.address == null) {
			removeEnd();
			return;
		}
		temp.address = temp.getAddress().getAddress();
		size--;

	}
	public void removePosition(int index) {
		if (head == null) return;
		if (size == 1) {
			head = null;
			tail = null;
			return;
		}
		int counter = 0;
		Node obj = head;
		while (counter != index - 1) {
			obj = obj.getAddress();
			counter++;
		}
		obj.address = obj.getAddress().getAddress();
		size--;
	}
	public void setSize(int value) {
		this.size = value;
	}
	public void print() {
		Node obj = head;
		if (head == null) {
			System.out.println("Steque is empty.");
			return;
		}
		while (obj.getAddress() != null) {
			System.out.print(obj.data + ", ");
			obj = obj.getAddress();
		}System.out.print(obj.data);
		System.out.println();
	}
}