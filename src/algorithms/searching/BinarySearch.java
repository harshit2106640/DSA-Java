package algorithms.searching;

public class BinarySearch {



    // Here We consider Like We don't know that array is in Ascending order or in descending order.
    public int binarySearch(int [] arr2 , int target){

        if(arr2 == null || arr2.length == 0){
            return -1;
        }

        int low = 0;
        int high = arr2.length - 1;
        boolean isAscending = arr2[low] <= arr2[high];

        while(low <= high){
            int mid = low + (high - low) /2;

            if(arr2[mid] == target){
                return mid;
            }

            if(isAscending){
                if(arr2[mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
            else{
                if(arr2[mid] > target){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
