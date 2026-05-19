package datastructures.stack.dynamicarraystack;


import datastructures.stack.arraystack.ArrayStack;

// Stack implementation using array but here we resize the array when size is full.
public class DynamicArrayStack extends ArrayStack {
    public DynamicArrayStack(int size){
        super(size);
    }

    @Override
    public void push(int element) {
        if(isFull()){
            resize();
        }

        arr[++top] = element;
    }

    private void resize(){
        int[] newArr = new int[arr.length * 2];

        for(int i = 0 ; i < arr.length ; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }


}
