class Solution {
    public boolean increasingTriplet(int[] nums) {
        // We can do it with prefixsum and suffixsum....Calculate left smaller and right greater for each element than check each element with left and right.

        // 2nd approach is for calculate the first smallest and second number smallest but greater than first.
        // Than check the third number if greater than both true else false;

        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int num:nums){
            if(num <= first){
                first = num;
            }
            else if(num <= second){
                second = num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}