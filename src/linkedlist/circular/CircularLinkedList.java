package linkedlist.circular;

public class CircularLinkedList {

    Node head;

    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            head.next = head;
            return ;
        }

        Node current = head;

        while(current.next != head){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        head = newNode;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            head.next = newNode;
            return;
        }

        Node current = head;

        while(current.next != head){
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
    }

    void insertBeforePosition(int data , int pos){
        Node newNode = new Node(data);
        int currentPosition = 1;

        if(head == null){
            System.out.println("List is empty... ");
            return;
        }

        if(pos <= 0){
            System.out.println("Invalid position...");
            return;
        }
        Node current = head;
        if(pos == 1){
            while(current.next != head){
                current = current.next;
            }
            newNode.next = head;
            current.next = newNode;
            head = newNode;
            return;
        }

        while(currentPosition < pos - 1 && current.next != head){
            current = current.next;
            currentPosition++;
        }

        // Check if position is valid
        if (currentPosition != pos - 1) {
            System.out.println("Invalid position...");
            return;
        }

        // Insert node
        newNode.next = current.next;
        current.next = newNode;
    }


    void deleteFromBeginning(){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        if(head == head.next){
            head = null;
            return;
        }

        Node current = head;

        while(current.next != head){
            current = current.next;
        }
        current.next = head.next;
        head = head.next;
    }

    void deleteFromEnd(){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        if(head == head.next){
            head = null;
            return;
        }


        Node current = head;
        while(current.next.next != head){
            current = current.next;
        }

        current.next = head;

        // Alternate way with prev pointer
//        Node prev = null;
//        Node curr = head;
//
//        while (curr.next != head) {
//            prev = curr;
//            curr = curr.next;
//        }
//
//        prev.next = head;
    }

    void deleteFromPosition(int pos){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        if(pos <= 0){
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            // Only one node
            if (head.next == head) {
                head = null;
                return;
            }

            Node current = head;

            // Find last node
            while (current.next != head) {
                current = current.next;
            }

            current.next = head.next;
            head = head.next;
            return;
        }

        Node current = head;
        int currentPosition = 1;
        while (currentPosition < pos - 1 && current.next != head) {
            current = current.next;
            currentPosition++;
        }

        if (currentPosition != pos - 1 || current.next == head) {
            System.out.println("Invalid Position");
            return;
        }

        current.next = current.next.next;
    }


    void countNodesOfCLL(){
        Node temp = head;
        int count = 0;
        if(head == null){
            System.out.println("Total Nodes of CLL is : "+count);
            return;
        }

        do{
            temp = temp.next;
            count++;
        }while(temp != head);

        System.out.println("Total Nodes of CLL is : "+count);
    }

    boolean searchElement(int value){
        if(head == null){
            return false;
        }

        Node temp = head;
        do{
            if(temp.data == value){
                return true;
            }
            temp = temp.next;

        }while(temp != head);
        return false;
    }

//    void convertToSL(){
//        if(head == null){
//            System.out.println("Empty list....");
//            return;
//        }
//
//        Node temp = head;
//        while(temp .next != head){
//            temp = temp.next;
//        }
//        temp.next = null;
//    }


    void isAscending(){
        if(head == null){
            System.out.println("List is empty.....");
            return;
        }

        boolean isAscending = true;
        int dropCount = 0;
        Node temp = head;

        do{
            int small = temp.data;
            Node nextNode = temp.next;

            if(small > nextNode.data){
                dropCount++;
                if(dropCount > 1){
                    isAscending = false;
                    break;
                }
            }
            temp = temp.next;
        }while(temp != head);

        if(isAscending){
            System.out.println("List is in Ascending order");
        }else{
            System.out.println("List is not in ascending order.");
        }
    }
    void traverseCLL(){
        if(head == null){
            System.out.println("List is empty....");
            return;
        }
        Node current = head;

        do{
            System.out.print(current.data +" ->");
            current = current.next;
        }while(current != head);
        System.out.print("(head)");
        System.out.println();
    }

}
