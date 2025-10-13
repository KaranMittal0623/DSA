class Solution {
    public int lastRemaining(int n) {
        return helper(n,true);
    }
    public int helper(int n,boolean leftToRight){
        if(n==1) return 1;

        // Now if we will go from left to right eliminate the positions...1,3,5,7,9
        // We will keep the positions that are 2,4,6,8 that are eqaul to 2 * (1,2,3,4)
        if(leftToRight || n%2 == 1){
            return 2 * helper(n/2 , !leftToRight);
        }
        else{
            return 2 * helper(n/2, !leftToRight) - 1;
        }
    }
}