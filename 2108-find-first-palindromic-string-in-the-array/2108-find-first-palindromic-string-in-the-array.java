class Solution {
    public String firstPalindrome(String[] words) {
        String ans = "";
        for(int i=0;i<words.length;i++){
            if(isPalindrome(words[i])){
                ans = words[i];
                break;
            }
        }
        return ans;
    }
    public boolean isPalindrome(String word){
        int l=0;int r=word.length()-1;
        while(l<=r){
            if(word.charAt(l)!=word.charAt(r)){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}