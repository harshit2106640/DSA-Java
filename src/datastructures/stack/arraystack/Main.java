package datastructures.stack.arraystack;

public class Main {
    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(10);
        stack.push(10);
        stack.push(15);
        stack.push(30);
        stack.push(45);
        stack.push(50);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Peek : "+stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
