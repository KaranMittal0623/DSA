class Solution {
    public void nextPermutation(int[] nums) {
        // find the break point
        int idx = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        // If not break point just sort nums
        if(idx == -1){
            Arrays.sort(nums);
            return;
        }
        // now find just greater than the break point
        for(int i=n-1;i>=idx;i--){
            if(nums[i]>nums[idx]){
                swap(nums,i,idx);
                break;
            }
        }
        // Sort /reverse the remaining
        reverse(nums,idx+1,n-1);
    }

    public void swap(int[] nums,int i , int idx){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
    public void reverse(int[] nums,int left,int right){
        while(left<=right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

