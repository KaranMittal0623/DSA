import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int left = 0; left < n; left++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int evenDistinct = 0;
            int oddDistinct = 0;

            for (int right = left; right < n; right++) {
                int num = nums[right];

                freq.put(num, freq.getOrDefault(num, 0) + 1);

                if (freq.get(num) == 1) {
                    if (num % 2 == 0)
                        evenDistinct++;
                    else
                        oddDistinct++;
                }

                if (evenDistinct == oddDistinct) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
        }

        return maxLen;
    }
}
