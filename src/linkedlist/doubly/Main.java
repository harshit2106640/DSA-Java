package linkedlist.doubly;

public class Main {
    static void main() {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.insertAtBeginning(19);
        obj.insertAtBeginning(10);
        obj.insertAtEnd(20);
        obj.insertAtEnd(25);
        obj.insertAtEnd(39);
        obj.insertAtPosition(12,2);
        obj.traverseForward();
        obj.traverseBackward();
        obj.deleteAtBeginning();
        obj.traverseForward();
        obj.deleteAtEnd();
        obj.traverseForward();

        obj.countNodesOfDLL();
    }
}
