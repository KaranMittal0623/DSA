class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Isme hum kya krenge ki.... dp array bnayange and hr ek letter ke corresponding dp array me true ya false store krenge ki hum us letter tk word bna skte hai yaa fr nhi...and jitni uski length hogi uske first character ko check krenge agr false hua toh word bn skta hai ..agr true hua toh word nhi bn skta
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = 0;
        // Word ki max length find krlo pehle
        for(String word : wordSet){
            maxLen = Math.max(maxLen,word.length());
        }

        int n = s.length();
        // jitni length ki string hai utni length ka dp bnao hr character stroe krne kelite true ya false
        boolean[] dp = new boolean[n+1];

        dp[0] = true;

        // ht position pe jaakr check krlo ki word bn skta hai ya nhiii
        for(int i=1;i<=n;i++){
            for(int j = i-1;j>=Math.max(0,i-maxLen);j--){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];

    }
}