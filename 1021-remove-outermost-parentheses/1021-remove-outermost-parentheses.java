class Solution {
    public String removeOuterParentheses(String s) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(counter>0){
                    sb.append(ch);
                }
                counter++;
            }
            else{
                counter--;
                if(counter>0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}