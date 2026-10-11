class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelledOrdersCleanup {

    static Node removeAll(Node head, int code) {

        // Remove matching nodes from the front
        while (head != null && head.data == code) {
            head = head.next;
        }

        Node temp = head;

        // Remove matching nodes from the remaining list
        while (temp != null && temp.next != null) {
            if (temp.next.data == code) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(5);

        head = removeAll(head, 5);
        display(head);

        Node head2 = new Node(5);
        head2.next = new Node(5);
        head2.next.next = new Node(5);

        head2 = removeAll(head2, 5);
        display(head2);
    }
}