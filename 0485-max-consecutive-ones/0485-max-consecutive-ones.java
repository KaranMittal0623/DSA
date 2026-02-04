class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Can be done by 2 pointer window technique 
        int i=0;int j=0;
        int max = 0;
        while(j<nums.length){
            if(nums[j]==1){
                j++;
            }
            if(j==nums.length || (j<nums.length && nums[j]==0)){
                max = Math.max(max,(j-i));
                i=j+1;
                j=i;
            }
        }
        return max;
    }
}