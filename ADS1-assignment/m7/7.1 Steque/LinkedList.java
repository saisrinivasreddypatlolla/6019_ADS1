/**.
 * Class for node.
 */
class Node {
	/**.
	 * this variable stores
	 * the input data.
	 */
	int data;
	/**.
	 * this variable stores the next address.
	 */
	Node address;
	/**.
	 * Constructs the object.
	 *
	 * @param      data1  The data 1
	 */
	Node(int data1) {
		this.data = data1;

	}
	/**.
	 * Constructs the object.
	 */
	Node() {

	}
	/**.
	 * Gets the data.
	 *
	 * @return     The data.
	 */
	public int getData() {
		return this.data;
	}
	/**.
	 * Gets the address.
	 *
	 * @return     The address.
	 */
	public Node getAddress() {
		return this.address;
	}
	/**.
	 * Sets the address.
	 *
	 * @param      address1  The address 1
	 */
	public void setAddress(Node address1) {
		this.address = address1;
	}
}
/**.
 * List of linkeds.
 */
class LinkedList {
	/**.
	 * size of the linked list.
	 */
	int size = 0;
	/**.
	 * head pointing to starting
	 * node.
	 */
	Node head;
	/**.
	 * tail pointing to end node
	 */
	Node tail;
	/**.
	 * Adds a node at start.
	 * time complexity of this method is
	 * O(1)
	 *
	 * @param      item  The item
	 */
	public void addStart(final int item) {
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
	/**
	 * Adds a node at end.
	 * time complexity of the method is O(1)
	 *
	 * @param      item  The item
	 */
	public void addEnd(final int item) {
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
	/**.
	 * Adds an item after the element.
	 * time complexity is O(N)
	 * to find the element we have check
	 * element from the head to that node.
	 *
	 * @param      element1  The element 1
	 * @param      item      The item
	 */
	public void addElement(final int element1, final int item) {
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
	/**.
	 * Adds an item in that position.
	 * Time complexity is O(N)
	 * to reach the index we have to take an counter
	 * from head until to reach the index.
	 *
	 * @param      index  The index
	 * @param      item   The item
	 */
	public void addPosition(final int index, final int item) {
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
	/**.
	 * Removes at the start of linkedlist.
	 * Time complexity is O(N)
	 */
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
	/**.
	 * Removes at the end of linkedlist.
	 * time complexity is O(N)
	 * to reach last element we have to take
	 * an temp node from start to until to reach
	 * the previous element from last.
	 */
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
	/**.
	 * Removes the item after that element.
	 * time complexity is O(N)
	 * to find the element we have check
	 * element from the head to that node.
	 *
	 * @param      item  The item
	 */
	public void removeElement(final int item) {
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
	/**.
	 * Removes an item in that position.
	 * Time complexity is O(N)
	 * to reach the index we have to take an counter
	 * from head until to reach the index.
	 *
	 * @param      index  The index
	 */
	public void removePosition(final int index) {
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
	/**.
	 * Sets the size.
	 *
	 * @param      value  The value
	 */
	public void setSize(final int value) {
		this.size = value;
	}
	/**.
	 * this method prints the all the elements
	 * in linkedlist.
	 */
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