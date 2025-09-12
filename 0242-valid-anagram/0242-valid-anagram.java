class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> check = new HashMap<>();
        int len1= s.length();
        int len2 = t.length();

        if(len1!=len2){
            return false;
        }

        for(int i=0;i<len1;i++){
            check.put(s.charAt(i),check.getOrDefault(s.charAt(i),0)+1);
        }

        for(int j=0;j<len2;j++){
            if(!check.containsKey(t.charAt(j)) || check.get(t.charAt(j))==0){
                return false;
            }
            check.put(t.charAt(j),check.get(t.charAt(j)) - 1);
        }
        return true;

    }
}