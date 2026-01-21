class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0,s,result,path);
        return result;
    }
    public void solve(int index, String s, List<List<String>> result, List<String> path){
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if (isPalindrome(index,i,s)){
                path.add(s.substring(index,i+1));
                solve(i+1,s,result,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}