class Solution {
    public int integerReplacement(int n) {
        return solve((long)n);
    }
    public int solve(long n){
        int ans = 0;
        if(n<=1){
            return 0;
        }
        if(n%2==0){
            ans = 1+ solve(n/2);
        }
        else if(n%2==1){
            ans = 1+Math.min(solve(n+1),solve(n-1));
        }
        return ans;
    }
}