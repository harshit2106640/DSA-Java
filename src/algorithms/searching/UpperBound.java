package algorithms.searching;

public class UpperBound {

    public int upperBound(int[] arr , int target){
        int low = 0;
        int high = arr.length - 1;

        if(arr == null || arr.length == 0){
            return -1;
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        UpperBound ub = new UpperBound();
        int[] arr = new int[] {1,1,1,2,3,4,10,11,15,20,20,20,20,25};
        int target = 19;
        System.out.println("Upper Bound : " +ub.upperBound(arr,target));
    }
}
