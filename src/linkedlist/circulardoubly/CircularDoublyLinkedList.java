package linkedlist.circulardoubly;

public class CircularDoublyLinkedList {
    Node head;


    void insertAtBeginning(int data){
        Node newNode = new Node(data);


        if(head == null){

            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

//        newNode.next = head;
//        newNode.prev = head.prev;
//        head.prev = newNode;
//        newNode.prev.next = newNode;
//        head = newNode;


        // Alternate approach

        Node last = head.prev;  // We just store the value in last instead of newNode.prev.next that's it.

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
        head = newNode;

    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
    }

    void insertAtPosition(int data , int pos){
        Node newNode = new Node(data);

        if(pos <= 0){
            System.out.println("Position is invalid...");
            return;
        }

        if(pos == 1){
            if(head == null){
                newNode.next = newNode;
                newNode.prev = newNode;
                head = newNode;
                return;
            }

            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            last.prev = newNode;
            head = newNode;
            return;
        }

        Node temp = head;
        int currentPosition = 1;

        while(currentPosition < pos -1 && temp.next != head) {
            temp = temp.next;
            currentPosition++;
        }

        if(currentPosition != pos - 1 ){
            System.out.println("Position is invalid");
            return;
        }

        Node nextNode = temp.next;
        newNode.next = nextNode;
        newNode.prev = temp;
        temp.next = newNode;
        nextNode.prev = newNode;
    }

    void insertAfterGivenValue(int target , int data){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        Node temp = head;

        do{
            if(temp.data == target){
                Node newNode = new Node(data);

                Node nextNode = temp.next;

                newNode.next = nextNode;
                newNode.prev = temp;

                temp.next = newNode;
                nextNode.prev = newNode;

                return;
            }

            temp = temp.next;
        }while(temp != head);

        System.out.println("Value is not present.");
    }


    void deleteFromBeginning(){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        if(head.next == head){
            head.next = null;
            head.prev = null;
            head = null;
            return;
        }

        Node nextNode = head.next;
        Node lastNode = head.prev;

        nextNode.prev = lastNode;
        lastNode.next = nextNode;
        head.next = null;
        head.prev = null;
        head = nextNode;


    }

    void deleteFromEnd(){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        if(head.next == head){
            head.next = null;
            head.prev = null;
            head = null;
            return;
        }

        Node lastNode = head.prev;
        Node secondLastNode = lastNode.prev;

        head.prev = secondLastNode;
        secondLastNode.next = head;

        lastNode.prev = null;
        lastNode.next = null;
    }

    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid position...");
            return;
        }

        // Case 1: delete first node
        if (pos == 1) {
            // single node
            if (head.next == head) {
                head = null;
                return;
            }

            Node last = head.prev;
            Node newHead = head.next;

            last.next = newHead;
            newHead.prev = last;

            head.next = null; // optional cleanup
            head.prev = null;

            head = newHead;
            return;
        }

        // Case 2: delete at other positions
        Node temp = head;
        int currentPosition = 1;

        while (currentPosition < pos && temp.next != head) {
            temp = temp.next;
            currentPosition++;
        }

        // If position is invalid
        if (currentPosition != pos) {
            System.out.println("Invalid position...");
            return;
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        // optional cleanup
        temp.next = null;
        temp.prev = null;
    }

    void convertToCLL(){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        Node temp = head;

        do{
            temp.prev = null;
            temp = temp.next;
        }while(temp != head);
    }

    void deleteAllOccurrences(int target) {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        boolean found = false;

        // 🔹 Step 1: Remove matching head nodes
        while (head != null && head.data == target) {

            found = true;

            // Single node
            if (head.next == head) {
                head = null;
                return;
            }

            Node last = head.prev;

            head = head.next;

            last.next = head;
            head.prev = last;
        }

        // If list became empty
        if (head == null) return;

        // 🔹 Step 2: Remove remaining nodes
        Node current = head.next;

        while (current != head) {

            if (current.data == target) {
                found = true;

                Node prev = current.prev;
                Node next = current.next;

                prev.next = next;
                next.prev = prev;

                current = next; // move forward safely
            } else {
                current = current.next;
            }
        }

        if (!found) {
            System.out.println("Value not found...");
        }
    }

    void insertBeforeValue(int value,int data){

        if(head == null){
            System.out.println("List is empty...");
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        do{
            Node prevNode = temp.prev;

            if(temp.data == value){

                // single node
                if(head == head.next){
                    temp.next = newNode;
                    temp.prev = newNode;
                    newNode.prev = temp;
                    newNode.next = temp;
                    head = newNode;
                    return;
                }

                // general case
                newNode.prev = prevNode;
                newNode.next = temp;
                prevNode.next = newNode;
                temp.prev = newNode;

                // 🔥 missing edge case fix
                if(temp == head){
                    head = newNode;
                }

                return;
            }

            temp = temp.next;

        }while(temp != head);

        System.out.println("Value is not found");
    }

    void deleteNthFromEnd(int n){
        if(head == null){
            System.out.println("List is empty...");
            return;
        }

        Node temp = head;
        int count = 0;

        do{
            count++;
            temp = temp.next;
        }while(temp != head);

        if(n > count || n <= 0){
            System.out.println("Invalid nth for this list");
            return;
        }

        int pos = count - n + 1;

        // single node
        if(head.next == head){
            head = null;
            return;
        }

        // delete head
        if(pos == 1){
            Node last = head.prev;
            Node newHead = head.next;

            last.next = newHead;
            newHead.prev = last;

            head = newHead;
            return;
        }

        // delete other node
        temp = head;
        int currentPosition = 1;

        while(currentPosition < pos){
            temp = temp.next;
            currentPosition++;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void traverse(){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        Node temp = head;

        do{
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }while(temp != head);

        System.out.println("(head)");
    }
}
