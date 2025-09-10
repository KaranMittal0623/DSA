class Solution {
    public void sortColors(int[] nums) {
        // In this we will use 3 pointer start , end , middle
        int start = 0, middle = 0;
        int end = nums.length-1;

        while(middle<=end){
            // If we get 0 swap it with starting idx
            if(nums[middle]==0){
                swap(nums,middle,start);
                middle++;
                start++;
            }
            // If we get 1 just hold the start pointer and move middle forward to find the next 0
            else if(nums[middle] == 1){
                middle++;
            }
            // If we get 2 swap it with the last idx
            else if(nums[middle]==2){
                swap(nums,middle,end);
                end--;
            }
        }
    }
    public void swap(int[] nums,int firstIdx, int secondIdx){
        int temp = nums[firstIdx];
        nums[firstIdx] = nums[secondIdx];
        nums[secondIdx] = temp;
    }
}