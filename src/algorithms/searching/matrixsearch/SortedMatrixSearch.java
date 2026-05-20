package algorithms.searching.matrixsearch;

public class SortedMatrixSearch {
    public int[] search(int[][] arr , int target){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return new int[] {-1,-1};
        }

        int rowLow = 0;
        int rowHigh = arr.length-1;

        while(rowLow <= rowHigh){
            int rowMid= rowLow + (rowHigh - rowLow) / 2;

            if(target >= arr[rowMid][0]   && target <= arr[rowMid][arr[0].length - 1] ){
                int index = binarySearch(arr[rowMid],target);

                if(index != -1){
                    return new int[] {rowMid,index};
                }
            } else if (arr[rowMid][0] < target) {
                rowHigh = rowMid - 1;
            }else {
                rowLow = rowMid + 1;
            }
        }
        return new int[] {-1,-1};
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
        SortedMatrixSearch obj = new SortedMatrixSearch();
        int[][] arr = new int[][] {
                {5,7,9,10},
                {12,15,18,30},
                {31,32,34,35},
                {38,40,41,45}
        };

        int target = 34;

        int[] result = obj.search(arr,target);

        if(result[0] != -1){
            System.out.println("Element found at row : "+result[0]+ " , columns : "+result[1]);
        }else{
            System.out.println("Element not found....");
        }
    }
}
