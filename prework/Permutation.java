public class Solution {
    public int[][] permute(int[] input) {
        List<int[]> output = getPerms(input, 0);
        output.add(input);
        
        int [][] arrayOut = new int[output.size()][];
        int i=0;
        for (int[] ar: output) {
            arrayOut[i++] = ar;
        }
        
        return arrayOut;
    }
    
    private List<int[]> getPerms(int[] input, int pointer) {
         if (input == null || pointer == input.length - 1) {
            return new ArrayList<int[]>();
        }

         Arrays.sort(input, pointer + 1, input.length);
        List<int[]> perms = new ArrayList<int[]>();
        perms.addAll(getPerms(input, pointer + 1));

        for (int i = pointer + 1; i < input.length; i++) {
            if (i != input.length-1 && input[i] == input[i+1]) {
                continue;
            }
            
            int[] arr = getArray(input);
            
            if (swap(arr, i, pointer)) {
                perms.add(arr);
                perms.addAll(getPerms(arr, pointer + 1));
            }
        }

        return perms;
    }

    private int[] getArray(int[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }

        return output;
    }

    private boolean swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;

        return input[i] != input[j];
    }
}

