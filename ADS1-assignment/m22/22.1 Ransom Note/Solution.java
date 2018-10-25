import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * data.
     */
    private String data;
    /**
     * number of occurences.
     */
    private int count = 1;
    /**
     * next node address.
     */
    private Node next = null;
    /**
     * Constructs the object.
     *
     * @param      d     data of node
     */
    Node(final String d) {
        data = d;
    }
    /**
     * Gets the data.
     *
     * @return     The data.
     */
    public String getData() {
        return data;
    }
    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNext() {
        return next;
    }
    /**
     * Sets the next.
     *
     * @param      n     next node address
     */
    public void setNext(final Node n) {
        next = n;
    }
    /**
     * Gets the count.
     *
     * @return     The count.
     */
    public int getCount() {
        return count;
    }
    /**
     * Sets the count.
     *
     * @param      count1     set the count value
     */
    public void setCount(final int count1) {
        count = count1;
    }
}
/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * head of linked list.
     */
    private Node head = null;
    /**
     * Gets the head.
     *
     * @return     The head.
     */
    public Node getHead() {
        return head;
    }
    /**
     * add new node to linked list.
     * time complexity for insertion is O(log(N))
     * @param      word  The word
     */
    public void insert(final String word) {
        Node newnode = new Node(word);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            boolean flag = false;
            while (temp != null) {
                if (temp.getData().equals(word)) {
                    flag = true;
                    temp.setCount(temp.getCount() + 1);
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
            if (!flag) {
                newnode.setNext(head);
                head = newnode;
            }
        }
    }
}
/**
 * Class for hashing.
 */
class Hashing {
    /**
     * hash table of lonked list objects.
     */
    private Linkedlist[] hash;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      size1     size of hash table.
     */
    Hashing(final int size1) {
        size = size1;
        hash = new Linkedlist[size1];
    }
    /**
     * position of given word.
     *
     * @param      value  The value
     *
     * @return     returns the position of word in hash table
     */
    public int key(final String value) {
        return Math.abs(value.hashCode() % size);
    }
    /**.
     * insert into hash table
     * time complexity for insert is O(log(N))
     * @param      word  The word
     * @param      pos   The position
     */
    public void insert(final String word, final int pos) {
        if (hash[pos] == null) {
            Linkedlist l = new Linkedlist();
            l.insert(word);
            hash[pos] = l;
        } else {
            hash[pos].insert(word);
        }
    }
    /**
     * Gets the hash.
     *
     * @return     The hashtable.
     */
    public Linkedlist[] getHash() {
        return hash;
    }
}
/**
 * Class for ransom note.
 */
class RansomNote {
    /**
     * magazine size.
     */
    private int magazinesize;
    /**
     * note size.
     */
    private int notesize;
    /**
     * magazine.
     */
    private String[] magazine;
    /**
     * note.
     */
    private String[] note;
    /**
     * hashing class varaible.
     */
    private Hashing h;
    /**
     * Constructs the object.
     *
     * @param      msize    magazine size
     * @param      nsize    note size
     * @param      magazines     magazine
     * @param      notes     note
     */
    RansomNote(final int msize, final int nsize, final String[] magazines,
               final String[] notes) {
        magazinesize = msize;
        notesize = nsize;
        magazine = magazines;
        note = notes;
        h = new Hashing(magazinesize);
    }
    /**
     * creates the hashtable for magazine.
     */
    public void creatingHashtable() {
        for (int i = 0; i < magazinesize; i++) {
            int pos = h.key(magazine[i]);
            h.insert(magazine[i], pos);
        }
    }
    /**
     * checks whether magazine contain all words of note.
     * time complexity for search is O(log(N))
     */
    public void checking() {
        Linkedlist[] hashtable = h.getHash();
        for (int i = 0; i < notesize; i++) {
            int pos = h.key(note[i]);
            int flag = 0;
            Node temp = hashtable[pos].getHead();
            while (temp != null) {
                if (temp.getData().equals(note[i])) {
                    if (temp.getCount() > 0) {
                        flag = 1;
                        temp.setCount(temp.getCount() - 1);
                        break;
                    } else {
                        System.out.println("No");
                        return;
                    }
                } else {
                    temp = temp.getNext();
                }
            } if (flag == 0) {
                System.out.println("No");
                return;
            }

        }
        System.out.println("Yes");
    }

}
/**.
 * Solution class
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor
    }
    /**
     * main method to perform operations.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int magazinesize = sc.nextInt();
        int notesize = sc.nextInt();
        sc.nextLine();
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        RansomNote r = new RansomNote(magazinesize, notesize, magazine, note);
        r.creatingHashtable();
        r.checking();
    }
}
