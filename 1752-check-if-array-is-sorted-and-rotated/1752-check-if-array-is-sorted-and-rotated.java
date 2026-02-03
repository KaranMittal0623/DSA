class Solution {
    public boolean check(int[] nums) {
        int firstBreak = -1;
        int secondBreak = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1] && firstBreak==-1){
                firstBreak = i;
            }
            else if(nums[i] > nums[i+1] && secondBreak == -1){
                secondBreak = i;
                break;
            }
        }
        if(secondBreak != -1){
            return false;
        }
        else{
            if(firstBreak == -1){
                return true;
            }
            else if(firstBreak != -1 && nums[nums.length-1]<=nums[0]){
                return true;
            }
            else{
                return false;
            }
        }
    }
}