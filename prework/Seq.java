public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] a) {
        if (a == null) {
            return 0;
        }

        Set<Integer> nums = new HashSet<Integer>();
        
        for (int num : a) {
            nums.add(num);
        }
        
        int maxSeq = 0;
        for (int num : a) {
            if (nums.contains(num - 1)) {
                continue;
            }

            int nextNum = num + 1;
            int currentSeq = 1;

            while (nums.contains(nextNum)) {
                nextNum++;
                currentSeq++;
            }

            if (currentSeq > maxSeq) {
                maxSeq = currentSeq;
            }

        }

        return maxSeq;
    }
}

