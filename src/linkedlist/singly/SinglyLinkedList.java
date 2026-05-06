package linkedlist.singly;


public class SinglyLinkedList {
    private Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end (no tail → O(n))
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at position (1-based)
    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);

        // Insert at beginning
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        // Move to (pos - 1)th node
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Traverse / display
    public void traverse() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Reverse (iterative) — good for your testing
    public void reverse() {

        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // store next
            current.next = prev;      // reverse link
            prev = current;           // move prev
            current = next;           // move current
        }

        head = prev; // update head at the end
    }
}
