package datastructures.stack.arraystack;


// Stack implementation using Fixed Size Array.
public class ArrayStack {
    protected int[] arr;
    protected int top;

    /**
     * Creates stack with given capacity.
     *
     * @param size capacity of stack
     */
    public ArrayStack(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be greater than 0");
        }

        arr = new int[size];
        top = -1;
    }

    /**
     * Pushes element onto stack.
     *
     * @param element value to push
     */
    public void push(int element) {

        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }

        arr[++top] = element;
    }

    /**
     * Removes and returns top element.
     *
     * @return popped element
     */
    public int pop() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return arr[top--];
    }

    /**
     * Returns top element without removing it.
     *
     * @return top element
     */
    public int peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return arr[top];
    }

    /**
     * Checks whether stack is full.
     *
     * @return true if full
     */
    public boolean isFull() {
        return top == arr.length - 1;
    }

    /**
     * Checks whether stack is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns current stack size.
     *
     * @return number of elements
     */
    public int size() {
        return top + 1;
    }

    /**
     * Returns stack capacity.
     *
     * @return total capacity
     */
    public int capacity() {
        return arr.length;
    }
}
