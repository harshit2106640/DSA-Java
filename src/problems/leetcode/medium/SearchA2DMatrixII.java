package problems.leetcode.medium;


// LeetCode 240  : We have sorted rows and columns . It's also called as staircase problem.
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = 0;
        int cols = matrix[0].length - 1;

        while(rows < matrix.length && cols >= 0){
            if(target == matrix[rows][cols]){
                return true;
            }else if(target < matrix[rows][cols]){
                cols--;
            }else{
                rows++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        SearchA2DMatrixII obj = new SearchA2DMatrixII();
        int[][] matrix = new int[][] {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;
        boolean found = obj.searchMatrix(matrix,target);
        if(found){
            System.out.println("Element found ....");
        }else{
            System.out.println("Element not found....");
        }
    }
}
