class Solution {
    public void wiggleSort(int[] nums) {
        // isko hum simple trick follow krke kr skte aa extra space ke saath
        // array ko sort kro
        // fr bigger s start krke even odd index fill kro.....chlte chlte even index fill kro jb array khtm ho jaye toh
        int n = nums.length;
        int[] ans = new int[n];
        int idx = n-1;
        Arrays.sort(nums);
        for(int i=1;i<n;i+=2){
            ans[i] = nums[idx];
            idx--;
        }
        for(int i=0;i<n;i+=2){
            ans[i] = nums[idx];
            idx--;
        }
        for(int i=0;i<n;i++){
            nums[i] = ans[i];
        }

    }
}