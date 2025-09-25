class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startPoint = searchLeft(nums, target);
        int endPoint = searchRight(nums, target);
        return new int[]{startPoint, endPoint};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    ans = mid;  // Potential answer, but keep searching left
                }
                right = mid - 1;  // Search left for earlier occurrence
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ans = mid;  // Potential answer, but keep searching right
                }
                left = mid + 1;  // Search right for later occurrence
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}