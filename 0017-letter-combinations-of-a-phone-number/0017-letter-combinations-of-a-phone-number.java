class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return Collections.emptyList();
        String[] str = {"abc" , "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList();
        backTrack(result,"",str,digits);
        return result;
    }

    public void backTrack(List<String> result, String combination, String[] map, String digits){
        if(digits.isEmpty()){
            result.add(combination);
        }
        else{
            String letters = map[digits.charAt(0) - '2'];
            for(char letter : letters.toCharArray()){
                backTrack(result, combination + letter, map, digits.substring(1));
            }
        }
    }

}