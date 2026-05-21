package problems.leetcode.medium;

import java.util.Arrays;

public class FindFirstAndLastPosition {
    public int firstOccurrence(int[] nums,int target){
        int first=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return first;
    }
    public int lastOccurrence(int[] nums,int target){
        int last=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        int first=firstOccurrence(nums,target);
        if(first==-1){
            return result;
        }
        int last=lastOccurrence(nums,target);
        result[0]=first;
        result[1]=last;
        return result;
    }
    public static void main(String[] args){
        FindFirstAndLastPosition obj = new FindFirstAndLastPosition();
        int[] nums=new int[]{5,7,7,8,8,10};
        int target=8;
        int[] result=new int[2];
        result=obj.searchRange(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
