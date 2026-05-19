package algorithms.searching;

public class LowerBound {
    public int lowerBound(int[] arr , int target){
        int low = 0;
        int high = arr.length - 1;

        if(arr.length == 0 || arr == null){
            return -1;
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args){
        LowerBound lb = new LowerBound();
        int[] arr = new int[] {1,1,1,2,3,4,10,11,15,20,20,20,20,25};
        int target = 50;

        System.out.println("Lower Bound : "+lb.lowerBound(arr,target));

    }
}
