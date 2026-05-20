package algorithms.searching.matrixsearch;

public class SortedRowWiseMatrixSearch {


    public int[] search(int[][] arr , int target){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return new int[] {-1,-1};
        }

        int rows = arr.length;
        int columns = arr[0].length;

        for(int i = 0; i < rows ; i++){
            if(target >= arr[i][0] && target <= arr[i][columns - 1]){
                int index = binarySearch(arr[i],target);
                if(index != -1){
                    return new int[] {i,index};
                }
            }
        }
        return new int[] {-1 , -1};
    }

    public int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == arr[mid]){
                return mid;
            }else if(target > arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        SortedRowWiseMatrixSearch obj = new SortedRowWiseMatrixSearch();
        int[][] arr = new int[][] {{1,4,7,10},{23,41,56,60},{6,16,45,100}};
        int target = 56;
        int[] result = obj.search(arr,target);
        if(result[0] != -1){
            System.out.println("Element found at row : "+result[0]+ " , columns : "+result[1]);
        }else{
            System.out.println("Element not found....");
        }


    }
}
