package datastructures.stack.linkedliststack;


// Stack Implementation using Linked List

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}
public class LinkedListStack {
    private Node top;

    public void push(int element){
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        int element = top.data;
        top = top.next;
        return element;
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

}
