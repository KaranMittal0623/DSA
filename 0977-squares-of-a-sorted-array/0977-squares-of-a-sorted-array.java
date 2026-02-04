class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] result = new int[n];
        int idx = n-1;
        int left = 0;int right = n-1;
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[idx] = nums[left] * nums[left];
                idx--;
                left++;
            }
            else{
                result[idx] = nums[right] * nums[right];
                idx--;
                right--;
            }
        }
        return result;
    }
}