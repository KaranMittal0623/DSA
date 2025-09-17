class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int low = 1, high = x;
        while (low <= high) {
            // Prevent integer overflow
            int mid = low + (high - low) / 2;
            
            // Check if mid is the square root
            if (mid <= x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}