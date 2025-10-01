class Solution {
    public String reverseWords(String s) {
        // Two methods one with split and from array to string builder
        // Another with pointer from last 

        StringBuilder ans = new StringBuilder();
        String[] arr = s.split("\\s+");
        for(int i=arr.length-1;i>=0;i--){
            ans.append(arr[i]);
            if(i>0){
                ans.append(" ");
            }
        }
        return ans.toString().trim();

    }
}