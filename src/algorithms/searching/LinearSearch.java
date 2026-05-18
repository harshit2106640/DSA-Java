package algorithms.searching;

public class LinearSearch {

    /**
     * Performs linear search on an array.
     *
     * @param arr input array
     * @param target value to search
     * @return index of target if found, otherwise -1
     */
    public int linearSearch(int[] arr , int target){
        if(arr == null || arr.length == 0){
            return -1;
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public int transpositionLinearSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        // first element
        if (arr[0] == target) {
            return 0;
        }

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == target) {

                // swap with previous element
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;

                return i - 1;
            }
        }

        return -1;
    }

    /**
     * Performs Move-To-Front Linear Search.
     * When target is found, it is moved to index 0.
     *
     * @param arr input array
     * @param target value to search
     * @return new index of target after moving to front, otherwise -1
     */
    public int moveToFrontSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        // already at front
        if (arr[0] == target) {
            return 0;
        }

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == target) {

                int temp = arr[i];

                // shift elements right
                for (int j = i; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }

                // move target to front
                arr[0] = temp;

                return 0;
            }
        }

        return -1;
    }


    /**
     * Performs Sentinel Linear Search.
     * Reduces boundary checking by placing target temporarily
     * at the last index.
     *
     * @param arr input array
     * @param target value to search
     * @return index of target if found, otherwise -1
     */
    public int sentinelLinearSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;

        int lastElement = arr[n - 1];


        arr[n - 1] = target;

        int i = 0;


        while (arr[i] != target) {
            i++;
        }


        arr[n - 1] = lastElement;


        if (i < n - 1 || lastElement == target) {
            return i;
        }

        return -1;
    }


    /**
     * Performs Bidirectional Linear Search.
     * Searches simultaneously from both ends of the array.
     *
     * @param arr input array
     * @param target value to search
     * @return index of target if found, otherwise -1
     */
    public int bidirectionalLinearSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {


            if (arr[left] == target) {
                return left;
            }


            if (arr[right] == target) {
                return right;
            }

            left++;
            right--;
        }

        return -1;
    }
}


