class Solution {
    public int minimumCost(int[] nums) {
        // Simple first element toh subarray me include hoga ee hoga fr hum second and third find kr lenge
        int minCost = nums[0];
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<first){
                second = first;
                first = nums[i];
            }
            else if(nums[i]<second){
                second = nums[i];
            }
        }
        return minCost + first + second;
    }
}