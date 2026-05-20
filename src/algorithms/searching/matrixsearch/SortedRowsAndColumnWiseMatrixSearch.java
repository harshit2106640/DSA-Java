package algorithms.searching.matrixsearch;


// This is also famous as staircase search

public class SortedRowsAndColumnWiseMatrixSearch {

    public int[] search(int[][] arr , int target){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return new int[] {-1,-1};
        }

        int rows = 0;
        int columns = arr[0].length - 1;

        while(rows < arr.length && columns >= 0){
            if(target == arr[rows][columns]){
                return new int[] {rows,columns};
            } else if (target < arr[rows][columns]) {
                columns--;
            }else{
                rows++;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args){
        SortedRowsAndColumnWiseMatrixSearch obj = new SortedRowsAndColumnWiseMatrixSearch();
        int[][] arr = new int[][] {
                {5,15,25,30},
                {7,16,26,31},
                {10,18,28,35},
                {20,21,30,40}
        };
        int target = 21;

        int[] result = obj.search(arr,target);

        if(result[0] != -1){
            System.out.println("element found at row : "+result[0]+ " , columns : "+result[1]);
        }else{
            System.out.println("element not found....");
        }
    }
}
