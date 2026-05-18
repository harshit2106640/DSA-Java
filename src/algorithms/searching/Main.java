package algorithms.searching;

public class Main {
    public static void main(){
        int [] arr = new int[] {20,5,10,10,15,34,10};
        int target = 36;
        LinearSearch ls = new LinearSearch();
//        int index = ls.linearSearch(arr,target);

//        int index = ls.transpositionLinearSearch(arr,target);
//
//        if(index != -1){
//            System.out.println("Element found at position : " +index);
//        }else{
//            System.out.println("Element not found...");
//        }


        int [] arr2 = new int[] {100,80,70,36,25,10,9};

        BinarySearch bs = new BinarySearch();
        int value = bs.binarySearch(arr2,target);

        if(value != -1){
            System.out.println("Element found at position : "+value);
        }else{
            System.out.println("Element not found...");
        }

    }
}
