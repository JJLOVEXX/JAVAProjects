import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    final static int length = 10;

    public static void creation(Node head) {
        for (int i = 1; i < length; i++) {
            Node newNode = new Node(i);
            head.next = newNode;
            head = head.next;
        }
    }

    public static void print(Node head) {
        System.out.print(head.data+"->");
        if (head.next != null) {
            print(head.next);
        }
        else{
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        creation(head);
        print(head);
        System.out.println("Hello World!");
    }
}
