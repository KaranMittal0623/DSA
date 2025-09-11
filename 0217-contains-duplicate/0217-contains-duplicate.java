class Solution {
    public boolean containsDuplicate(int[] nums) {

        // This is very simple method
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<=len-2;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;


        // We can also solve with the help of hash table to check if the value is repeated or not
    }
}