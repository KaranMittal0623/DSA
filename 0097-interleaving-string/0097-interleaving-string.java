class Solution {
    static int m,n,N;
    static int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,0,s1,s2,s3);
    }
    static boolean solve(int i,int j,int k,String s1,String s2,String s3){
        if(i==m && j==n && k==N){
            return true;
        }
        if (k >= N)
            return false;

        if(dp[i][j]!=-1){
            return dp[i][j] == 1;
        }
        boolean found = false;
        if(i<m && s1.charAt(i)==s3.charAt(k)){
            found = solve(i+1,j,k+1,s1,s2,s3);
        }
        
        if(!found && j<n && s2.charAt(j)==s3.charAt(k)){
            found = solve(i,j+1,k+1,s1,s2,s3);
        }
        dp[i][j] = found ? 1 : 0;
        return found;
    }
}