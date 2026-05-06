package linkedlist.circular;


public class Main {
    static void main() {
        CircularLinkedList obj = new CircularLinkedList();
        obj.insertAtBeginning(10);
        obj.insertAtBeginning(20);
        obj.insertAtBeginning(50);
        obj.insertAtBeginning(7);

        obj.traverseCLL();

        obj.insertAtEnd(8);
        obj.insertAtEnd(15);
        obj.traverseCLL();

        obj.insertBeforePosition(30,5);
        obj.traverseCLL();
        obj.deleteFromBeginning();
        obj.traverseCLL();
        obj.deleteFromEnd();
        obj.traverseCLL();
//        obj.deleteFromPosition(6);
        obj.traverseCLL();

        boolean isValid = obj.searchElement(8);
        if(isValid){
            System.out.println("Value is present in node");
        }else{
            System.out.println("Value is not present in node");
        }

        obj.traverseCLL();
        obj.isAscending();
    }
}
