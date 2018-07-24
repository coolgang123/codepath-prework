public class Solution {
    public int[][] prettyPrint(int n) {
        if (n < 1) {
            return null;
        }
        
        int size = (n * 2) - 1;
        int[][] arr = new int[size][size];

        rec(0, size - 1, arr, n);

        return arr;
    }
    
    private void rec(int start, int end, int[][] arr, int n) {
        if (start > end) {
            return;
        }

        for (int i = start; i <= end; i++) {
            arr[start][i] = n;
            arr[end][i] = n;
            arr[i][start] = n;
            arr[i][end] = n;
        }

        rec(start + 1, end - 1, arr, n - 1);
    }
}

