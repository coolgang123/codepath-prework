public class Solution {
    public int numRange(int[] input, int min, int max) {
        if (input == null || input.length == 0 || max < min) {
            return 0;
        }
        
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = i; j < input.length; j++) {
                sum = sum + input[j];

                if (sum > max) {
                    break;
                }
                
                if (sum >= min) {
                    count ++;
                }
            }
        }
        
        return count;
    }
}
