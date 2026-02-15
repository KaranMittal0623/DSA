class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        List<Integer> list = new ArrayList<>();

        if(s.length()<p.length()){
            return list;
        }
        for(int i=0;i<p.length();i++){
            freq1[s.charAt(i)-'a']++;
            freq2[p.charAt(i)-'a']++;
        }

        int start = 0;
        int right = p.length();

        if(Arrays.equals(freq1,freq2)){
            list.add(start);
        }

        while(right<s.length()){
            freq1[s.charAt(start)-'a']--;
            freq1[s.charAt(right)-'a']++;
            start++;
            right++;
            if(Arrays.equals(freq1,freq2)){
                list.add(start);
            }
        }
        return list;
    }
}