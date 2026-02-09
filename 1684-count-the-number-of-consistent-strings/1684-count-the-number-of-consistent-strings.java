class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] freq = new int[26];
        for(int i=0;i<allowed.length();i++){
            freq[i] = 0;
        }

        for(int i=0;i<allowed.length();i++){
            char ch = allowed.charAt(i);
            freq[ch - 'a']++;
        }

        int count = 0;
        for(int i=0;i<words.length;i++){
            String check = words[i];
            int j=0;
            while(j<check.length()){
                char ch = check.charAt(j);
                if(freq[ch-'a']==0){
                    break;
                }
                else{
                    j++;
                }
            }
            if(j==check.length()){
                count++;
            }
        }
        return count;
    }
}