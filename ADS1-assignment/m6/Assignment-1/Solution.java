import java.util.Scanner;
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        String[] digits = number.split("");
        for (int i = 0; i < digits.length; i++) {
            l.addEnd(Integer.parseInt(digits[i]));
        }
        return l;

    }

    public static String digitsToNumber(LinkedList list) {
        return list.toString();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList l = new LinkedList();
        int size = 0;
        if (list1.getSize() < list2.getSize()) {
            size = list2.getSize();
        } else {
            size = list1.getSize();
        }
        int carry = 0, value = 0;
        for (int i = size; i > 0; i--) {
            value = list1.removeEnd() + list2.removeEnd();
            value = value + carry;
            carry = value / 10;
            value = value % 10;
            l.addStart(value);
        }
        if (carry > 0) {
            l.addStart(carry);
        }
        return l;

    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
class LinkedList {
    class Node {
        int digit;
        Node address;
        Node(int item) {
            this.digit = item;
        }
        public int getDigit() {
            return this.digit;
        }
        public Node getAddress() {
            return this.address;
        }
        public void setAddress(Node address1) {
            this.address = address1;
        }
    }
    int size = 0;
    Node head;
    Node tail;
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
    public int removeEnd() {
        if (head == null) return 0;
        if (size == 1) {
            int data = head.getDigit();
            head = null;
            tail = null;
            return data;
        }
        Node temp = head;
        while (temp.address.address != null) {
            temp = temp.address;
        }
        int data = temp.getAddress().getDigit();
        temp.address = null;
        tail = temp;
        size--;
        return data;
    }
    public String toString() {
        Node temp = head;
        String str = "";
        while (temp.getAddress() != null) {
            str += temp.getDigit();
            temp = temp.getAddress();
        }
        return str + temp.getDigit();
    }
    public int getSize() {
        return this.size;
    }
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
}
