class Solution {
    public void swap(int first,int second,int[] nums){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
    public int removeDuplicates(int[] nums) {
        int count =1;
        int i=0,j=1;
        while(j<nums.length){
            if(nums[j]==nums[i]){
                j++;
            }
            else{
                swap(i+1,j,nums);
                i++;j++;
                count++;
            }
        }
        return count;
    }
}