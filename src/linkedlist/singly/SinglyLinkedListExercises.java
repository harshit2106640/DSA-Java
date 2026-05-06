package linkedlist.singly;


////1.	Create a Singly LinkedList having 5 nodes with values from 11 to 15
////Output: 11 -> 12 -> 13 -> 14 -> 15
//
////2.	Write a method to update the value at position 2, New Value = 20
////Output: 11 -> 20 -> 13 -> 14 -> 15
//
////3.	Write a method to get or print the value of the node which is at position 4
////Output: 14
////        [Hint: Assume that Position starts from 1]
//
////4.	Write a method to remove a node at the end of the Singly LinkedList. It should return the node removed.
////        Output: 15
//
////5.	Write a method to delete the first node in the linked list that contains the key. Key is given.
////        Input: 1 -> 2 -> 3 -> 2 -> 4, key = 2
////Output: 1 -> 3 -> 2 -> 4
//
//
////6.	Write a method to delete all Occurrence of the given key.
////        Input: 1 -> 2 -> 3 -> 2 -> 4, key = 2
////Output: 1 -> 3 -> 4
//

////7.	Write a method to delete the entire linked list.
//
//


public class SinglyLinkedListExercises {
    Node head;

    void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void updateValue(int value,int pos){
        if(pos <= 0){
            System.out.println("Pls enter valid position");
            return;
        }

        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        int currentPosition = 1;
        Node temp = head;
        while((temp != null) && currentPosition < pos){
            temp = temp.next;
            currentPosition++;
        }

        if(temp != null){
            temp.data = value;
        }else{
            System.out.println("Invalid position.....");
        }
    }
    void getValueAtPosition(int pos){
        if(pos <= 0){
            System.out.println("Invalid Position....");
            return;
        }
        if(head == null){
            System.out.println("List is empty....");
            return;
        }

        int currentPosition = 1;
        Node temp = head;

        while(temp != null && currentPosition < pos){
            temp = temp.next;
            currentPosition++;
        }

        if(temp == null){
            System.out.println("Invalid position");
        }else{
            System.out.println(temp.data);
        }
    }


    void getRemovedNodeAtLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(head.next == null){
            System.out.println(head.data);
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        System.out.println(temp.next.data);
        temp.next = null;

    }


    void deleteFirstOccurrence(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Case 1: head contains key
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Key not found");
    }


    void deleteAllOccurrences(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Step 1: Remove all occurrences at head
        while (head != null && head.data == key) {
            head = head.next;
        }

        // Step 2: Remove occurrences beyond head
        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next; // delete node
            } else {
                temp = temp.next; // move only if no deletion
            }
        }
    }

    void traverse() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();

    }
    void deleteList() {
        head = null;
    }
    static void main() {
        SinglyLinkedListExercises obj = new SinglyLinkedListExercises();
        obj.insertAtEnd(11);
        obj.insertAtEnd(12);
        obj.insertAtEnd(13);
        obj.insertAtEnd(14);
        obj.insertAtEnd(15);
        obj.traverse();
        obj.updateValue(20,2);
        obj.traverse();
        obj.getValueAtPosition(4);
        obj.getRemovedNodeAtLast();
        obj.traverse();
        obj.deleteList();
        obj.traverse();
        obj.insertAtEnd(1);
        obj.insertAtEnd(2);
        obj.insertAtEnd(3);
        obj.insertAtEnd(2);
        obj.insertAtEnd(4);
        obj.traverse();
        obj.deleteFirstOccurrence(2);
        obj.traverse();
        obj.insertAtEnd(2);
        obj.insertAtEnd(2);
        obj.insertAtEnd(2);
        obj.insertAtEnd(2);
        obj.traverse();
        obj.deleteAllOccurrences(2);
        obj.traverse();
    }
}
