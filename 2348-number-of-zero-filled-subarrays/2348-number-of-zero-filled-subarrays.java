class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i=0,j=0;
        long ans=0;
        while(i<nums.length){
            if(nums[i]!=0){
                i++;
                continue;
            }
            j=i;
            while(j<nums.length && nums[j]==0){
                j++;
            }
            int len = j-i;
            ans+= (long) len * (len+1)/2;
            i=j;
        }
        return ans;
    }
}