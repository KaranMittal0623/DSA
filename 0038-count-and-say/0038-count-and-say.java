class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";

        // Recursive call
        String say = countAndSay(n-1);

        // After at the end what is returned now apply logic on that

        StringBuilder result = new StringBuilder();
        for(int i=0;i<say.length();i++){
            int count = 1;
            char ch = say.charAt(i);
            while(i<say.length()-1 && say.charAt(i) == say.charAt(i+1)){
                count++;
                i++;
            }
            result.append(count).append(ch);
        }
        return result.toString();

    }
}