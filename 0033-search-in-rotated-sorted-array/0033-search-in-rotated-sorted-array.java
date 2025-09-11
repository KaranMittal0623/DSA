class Solution {
    public int search(int[] nums, int target) {
        int pivotIdx = findPivot(nums);
        
        // Search in left sorted part (from pivot to end)
        int leftSearch = binarySearch(0, pivotIdx - 1, nums, target);
        if (leftSearch != -1) {
            return leftSearch;
        }
        
        // Search in right sorted part (from pivot to end)
        return binarySearch(pivotIdx, nums.length - 1, nums, target);
    }

    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int middle = start + (end - start) / 2;
            
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return start;
    }

    public int binarySearch(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int middle = start + (end - start) / 2;
            
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}