package datastructures.stack.linkedliststack;

public class Main {
    public static void main(String[] args){
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(45);

        System.out.println("Peek: " + stack.peek());

        System.out.println("Popped: " + stack.pop());


    }
}
