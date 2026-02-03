class Solution {
    public int[] buildArray(int[] nums) {
        // Isko hum try krenge ki ek hi same array me new values store krenge kisi formula ke hisb se
        // Old value - num[i]%length
        // new value - num[i]/length

        for(int i=0;i<nums.length;i++){
            // Iss fornula ke help se hum dono values store kr rhe hai 
            nums[i] += (nums[nums[i]] % nums.length) * nums.length;
        }
        for(int i=0;i<nums.length;i++){
            // Ab actual new value ko store krdo
            nums[i] = nums[i] / nums.length;
        }
        return nums;
    }
}