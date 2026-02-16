class Solution {
    public int maxConsecutiveAnswers(String ans, int k) {
        int l=0;
        int max =0;
        int res = 0;
        int t=0,f=0;
        for(int r=0;r<ans.length();r++){
            if(ans.charAt(r)=='T') t++;
            if(ans.charAt(r)=='F') f++;

            max = Math.max(t,f);
            if(r-l+1-max > k){
                if(ans.charAt(l)=='T') t--;
                if(ans.charAt(l)=='F') f--;
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}