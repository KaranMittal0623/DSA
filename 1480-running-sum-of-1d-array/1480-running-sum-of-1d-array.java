class Solution {
    public int[] runningSum(int[] nums) {
        // Simple solution with constant space simple traversal 
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}