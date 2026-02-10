class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0 ;
        int end = 0;
        int n = fruits.length;
        int maxLen = 0;
        Map<Integer,Integer> track = new HashMap<>();
        while(end<n){
            track.put(fruits[end],track.getOrDefault(fruits[end],0)+1);
            while(track.size()>=3){
                track.put(fruits[start],track.get(fruits[start])-1);
                if(track.get(fruits[start])==0) track.remove(fruits[start]);
                start++;
            }
            int currLen = end - start + 1;
            maxLen = Math.max(currLen,maxLen);
            end++;
        }
        return maxLen;
    }
}