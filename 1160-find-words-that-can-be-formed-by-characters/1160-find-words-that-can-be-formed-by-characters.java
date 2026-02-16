class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0;i<chars.length();i++){
            char ch = chars.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(String word : words){
            if(canFormWord(word,new HashMap<>(map))){
                result += word.length();
            }
        }
        return result;
    }

    public boolean canFormWord(String word,Map<Character,Integer> freq){
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!freq.containsKey(ch) || freq.get(ch)==0){
                return false;
            }
            freq.put(ch,freq.get(ch)-1);
        }
        return true;
    }
}