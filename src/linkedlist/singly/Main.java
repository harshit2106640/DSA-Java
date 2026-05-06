package linkedlist.singly;

public class Main {
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.insertAtPosition(15, 2);

        list.traverse();   // 10 -> 15 -> 20 -> 30

        list.reverse();
        list.traverse();   // 30 -> 20 -> 15 -> 10
    }
}
