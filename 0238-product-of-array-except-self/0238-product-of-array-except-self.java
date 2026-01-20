class Solution {
    public int[] productExceptSelf(int[] nums) {
        // We can solve this question by prefix and suffix
        int n = nums.length;
        int ans[] = new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i] = nums[i-1] * ans[i-1];
        }
        int prevSuff = 1;
        for(int i=n-2;i>=0;i--){
            prevSuff *= nums[i+1];
            ans[i] *= prevSuff;
        }
        return ans;
    }
}