package linkedlist.circulardoubly;

public class Main {
    static void main() {
        CircularDoublyLinkedList obj = new CircularDoublyLinkedList();
        obj.insertAtBeginning(10);
        obj.insertAtBeginning(15);
        obj.insertAtBeginning(8);
        obj.insertAtBeginning(7);
        obj.insertAtBeginning(5);
        obj.traverse();

        obj.insertAtEnd(20);
        obj.insertAtEnd(30);
        obj.traverse();
        obj.insertAtPosition(85,8);
        obj.traverse();
        obj.insertAtPosition(50,4);
        obj.traverse();
        obj.deleteFromBeginning();
        obj.traverse();
        obj.deleteFromBeginning();
        obj.traverse();

        obj.deleteFromEnd();
        obj.traverse();
        obj.deleteFromEnd();
        obj.traverse();
        //obj.convertToCLL();
//        obj.traverse();
        obj.insertAtBeginning(10);
        obj.insertAtBeginning(10);


        obj.insertAtBeginning(10);
        // obj.insertAtBeginning(45);
        //obj.insertAtBeginning(20);
        obj.insertAtBeginning(10);
        obj.insertAtBeginning(10);
        //obj.insertAtBeginning(7);
        obj.insertAtBeginning(10);
        obj.traverse();
        obj.deleteAllOccurrences(10);
        obj.traverse();
        obj.insertAtEnd(10);
        obj.traverse();
        obj.deleteAllOccurrences(10);
        obj.traverse();

        obj.insertBeforeValue(8,10);
        obj.traverse();
        obj.deleteNthFromEnd(0);
        obj.traverse();
    }
}
