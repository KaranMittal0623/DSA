class Solution {
    public int findDuplicate(int[] nums) {
        // We will use slow fast pointer here...just traverse find the matching point
        int slow = 0,fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}