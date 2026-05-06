package linkedlist.doubly;

public class DoublyLinkedList {
    Node head;

    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }


        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }


    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;     // forward link
        newNode.prev = curr;     // backward link
    }


    void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);

        // Case 1: Insert at beginning
        if (pos == 1) {
            if (head != null) {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
            return;
        }

        Node temp = head;
        int currentPosition = 1;

        // Traverse to (pos - 1)
        while (temp != null && currentPosition < pos - 1) {
            temp = temp.next;
            currentPosition++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        // Case 2 & 3: Middle or End
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }


    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        Node temp = head;
        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        temp.next = null; // optional cleanup
    }


    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        // current is last node
        current.prev.next = null;
        current.prev = null; // optional cleanup
    }

    void countNodesOfDLL(){
        Node temp = head;
        int count = 0;

        while(temp != null){
            temp = temp.next;
            count++;
        }

        System.out.println("Total Nodes of DLL is : "+count);
    }

    void traverseForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        // Step 1: Go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Step 2: Traverse backward
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) {
                System.out.print(" <-> ");
            }
            temp = temp.prev;
        }
        System.out.println();
    }
}
