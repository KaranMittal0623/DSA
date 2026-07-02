class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]!=0){
                swap(i,j,nums);
                i++;
            }
            j++;
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}