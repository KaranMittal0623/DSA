class Solution {
    public int minSteps(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<s.length();i++){
            arr1[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            arr2[t.charAt(i)-'a']++;
        }
        int steps =0;
        for(int i=0;i<26;i++){
            steps += Math.abs(arr1[i]-arr2[i]);
        }
        return steps/2;
    }
}