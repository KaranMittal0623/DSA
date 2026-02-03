class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            int lastInt = nums[i];
            int lastDigit = k%10;
            int sum = carry + lastInt + lastDigit;
            ans.add(sum%10);
            carry = sum/10;
            k = k/10;
        }
        // If carry is remaing or k is pending
        while(k>0 || carry>0){
            int sum = (k%10) + carry;
            ans.add(sum%10);
            carry = sum/10;
            k = k/10;
        }
        Collections.reverse(ans);
        return ans;
    }
}