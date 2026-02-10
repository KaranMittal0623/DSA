class Solution {
    public int longestBalanced(int[] nums) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> evenFreq = new HashMap<>();
        Map<Integer, Integer> oddFreq = new HashMap<>();

        int distinctEven = 0, distinctOdd = 0;
        int diff = 0, maxLen = 0;

        firstIndex.put(0, -1); // base case

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (x % 2 == 0) {
                evenFreq.put(x, evenFreq.getOrDefault(x, 0) + 1);
                if (evenFreq.get(x) == 1) distinctEven++;
            } else {
                oddFreq.put(x, oddFreq.getOrDefault(x, 0) + 1);
                if (oddFreq.get(x) == 1) distinctOdd++;
            }

            diff = distinctEven - distinctOdd;

            if (firstIndex.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(diff));
            } else {
                firstIndex.put(diff, i);
            }
        }

        return maxLen;
    }
}
