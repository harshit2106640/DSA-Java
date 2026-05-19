package problems.leetcode.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args){
        SearchInsertPosition obj = new SearchInsertPosition();
        int[] arr=new int[]{1,3,5,6};
        int target=7;
        int result=obj.searchInsert(arr,target);
        System.out.println(result);
    }
}
