class Solution {
    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        ans.append(address.charAt(0));
        for(int i=1;i<address.length();i++){
            if(address.charAt(i)=='.'){
                ans.append('[');
                ans.append(address.charAt(i));
                ans.append(']');
            }
            else{
                ans.append(address.charAt(i));
            }
        }
        return ans.toString();
    }
}