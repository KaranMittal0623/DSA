class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backTrack(result,0,0,"",n);
        return result;
    }

    public void backTrack(List<String> result, int open,int close,String paren,int n){
        if(paren.length()==n*2){
            result.add(paren);
            return;
        }

        if(open < n){
            backTrack(result,open+1,close,paren+'(',n);
        }
        if(close < open){
            backTrack(result,open,close+1,paren+')',n);
        }
    }
}