/**.
 * LinkedList class
 *
 * @param      <E>   { parameter_description }
 */
class LinkedList<E>{
	/**.
	 * head node to point the first element
	 */
    Node head;
    /**.
     * size variable
     */
    int size;
    /**.
     * Node class to point the next cell
     */
    class Node{
    	/**.
    	 * Data variable
    	 */
        E data;
        /**.
         * Link object for pointing
         */
        Node link;
        /**.
         * Node constuctor without arguments.
         */
        Node(){
            this.data = null;
            this.link = null;
        }
        /**.
         * Node constructor with parameters
         *
         * @param      data  data
         */
        Node(E data){
            this.data = data;
            this.link = null;
        }
    }
    /**.
     * LinkedList constructor
     */
	LinkedList(){
        //head = new Node();
        size = 0;
	}
	/**.
	 * method to add the element at the end
	 *
	 * @param      data  The data
	 */
    public void addAtEnd(final E data){
        Node newNode;
        if(size == 0) {
            head = new Node(data);
            //head = newNode;
            size++;
            return;
        }
        Node current;
        current = head;
        while(current.link != null){
            current = current.link;
        }
        newNode = new Node(data);
        current.link = newNode; 
        size++;
    }
    /**.
     * method to addd at the start
     *
     * @param      data  The data
     */
    public void addAtStart(final E data){
        Node newNode = new Node(data);
        newNode.link = head;
        head = newNode;
        size++;
    }
    /**.
     * method to add at the given location
     *
     * @param      location  The location
     * @param      data      The data
     */
    public void addAtLocation(final int location, final E data){
        if(location >size){
            System.out.println("Invalid position Exception in add at location.");
            return;
        }
        Node newNode = new Node(data);
        int counter = 1;
        Node current = head;

        while(counter < location-1){
            current = current.link;
            counter++;
        }
        newNode.link = current.link;
        current.link = newNode;
        size++;

    }
    /**.
     * method to remove at the end
     */
    public void removeAtEnd(){
        if(size == 0){
            System.out.println("Deck is Empty");
            return;
        }
        Node current = head;
        int counter = 1;
        while(counter < size-1){
            current = current.link;
            counter++;
        }
        current.link = null;
        size--;
    }
    /**.
     * method to remove at start
     */
    public void removeAtStart(){
        if(size == 0){
            System.out.println("Deck is Empty");
            return; 
        }
        Node current = head;
        head = head.link;
        current.link = null;
        size--;
    }
    /**.
     * Method to remove at the given location
     *
     * @param      location  The location
     */
    public void removeAtLocation(final int location){
        if(size == 0){
            System.out.println("Deck is Empty");
        }
        if(location == size){
            removeAtEnd();
            size--;
            return;
        }
        if(location > size){
            System.out.println("Invalid location ");
            return;
        }
        Node current = head;
        int counter = 1;
        while(counter < location-1){
            current = current.link;
            counter++;
        }
        Node temp = current.link;
        current.link = temp.link;
        temp.link = null;
        size--;

    }
    /**.
     * Method to remove the given element
     *
     * @param      element  The element
     */
    public void removeElement(final E element){
        try{Node current = head;
        int counter = 1;
        while(current.data != element){
            current = current.link;
        }
        removeAtLocation(counter);
        } catch(Exception e){
            System.out.println("No element found for removeElement");
        }
    }
    /**.
     * print methood.
     */
    public void print(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        Node current = head;
        System.out.print("[");
        while(current.link != null){
            System.out.print(current.data +", ");
            current = current.link;
        }
        System.out.print(current.data+ "]");
        System.out.println();
    }
    /**.
     * method to return the data in the node
     *
     * @return     The list.
     */
    public String getList(){
        if(size == 0){
            return "[]";
        }
        Node current = head;
        String str = "[";
        while(current.link != null){
            str += current.data +", ";
            current = current.link;
        }
        str += current.data+ "]";
        return str;
    }
    /**.
     * method to return the size
     *
     * @return     The size.
     */
    public int getSize(){
        return this.size;
    }
    /**.
     * Method to return the linkedList object at the given index.
     *
     * @param      index  The index
     *
     * @return     The object.
     */
    public E getObject(final int index){
        if(size==0){
            return head.data;
        }
        Node current = head;
        int counter = 0;
        while(counter < index){
            current = current.link;
            counter++;
        }
        return current.data;

    }


}
