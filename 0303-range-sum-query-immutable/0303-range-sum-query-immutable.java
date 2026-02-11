class NumArray {
    int n[];
    public NumArray(int[] nums) {
        n = new int[nums.length];
        n[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            n[i] = n[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return n[right];
        return (n[right] - n[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */