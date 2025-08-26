class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> ans = new HashMap<>();

        // Traverse on each word
        for(String word : strs){
            // Sort the each word so that we can find the same anagrams by matching the direct word
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            // If word matches but it is first word than create key and new list
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList<>());
            }
            // If word match but key exists then just add original word to the list with that key
            ans.get(key).add(word);
        }
        return new ArrayList<>(ans.values());
    }
}