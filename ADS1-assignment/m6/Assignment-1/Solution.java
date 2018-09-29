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
        // String s = "";
        return list.toString();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList l = new LinkedList();

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
    public String toString() {
        Node temp = head;
        String str = "";
        while (temp.getAddress() != null) {
            str += temp.getDigit();
            temp=temp.getAddress();
        }
        return str + temp.getDigit();
    }
}
