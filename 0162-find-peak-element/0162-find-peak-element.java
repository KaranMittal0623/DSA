class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            // Check if mid is a peak
            if (nums[mid] > nums[mid + 1]) {
                // Peak is in the left half (including mid)
                r = mid;
            } else {
                // Peak is in the right half
                l = mid + 1;
            }
        }
        
        // When l == r, we've found a peak
        return l;
    }
}