class Solution {
    public int countGoodSubstrings(String s) {
        int l=0;
        int r=0;
        int count = 0;
        // int[] arr = new int[26];
        while(r<s.length()){
            if(r-l+1==3){
                if(s.charAt(l)!=s.charAt(l+1) && s.charAt(l+1)!=s.charAt(l+2) && s.charAt(l+2) != s.charAt(l)){
                    count++;
                }
                l++;
            }
            r++;
        }
        return count;
    }
}