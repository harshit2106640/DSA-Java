package algorithms.searching.matrixsearch;

public class MatrixLinearSearch {
    public int[] search(int[][] arr , int target){

        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return new int[] {-1,-1};
        }
        int rows = arr.length;
        int columns = arr[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(arr[i][j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args){
        MatrixLinearSearch mls = new MatrixLinearSearch();
        int[][] arr = new int[][] {{1,4,7,10},{23,41,56,60},{6,16,45,100}};
        int target = 41;
        int[] result = mls.search(arr,target);
        if(result[0] != -1){
            System.out.println("Element found at row : "+result[0]+" , column : "+result[1]);
        }else{
            System.out.println("Element not found in matrix.....");
        }
    }
}
