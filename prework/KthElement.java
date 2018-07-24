public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] arr, int k) {
        if (arr == null || k < 0 || k > arr.length){
           throw new IllegalStateException();
        }
        
        int min = 0;
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min || arr[i] > max) {
                continue;
            }

            int numberOfSmallerElements = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] >= arr[j]) {
                    numberOfSmallerElements++;
                }
            }

            if (numberOfSmallerElements == k) {
                return arr[i];
            }

            if (numberOfSmallerElements > k && arr[i] < max) {
                max = arr[i];
            }

            if (numberOfSmallerElements < k && arr[i] > min) {
                min = arr[i];
            }
        }

        return max;
    }
}

