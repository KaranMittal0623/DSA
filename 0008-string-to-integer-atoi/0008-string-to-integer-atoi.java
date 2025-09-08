class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = 1;
        long res = 0;
        s = s.trim();
        int len = s.length();
        if(len == 0) return 0;

        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(0) == '+'){
            i++;
        }

        while(i<len){
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9') break;

            res = res * 10 + (ch - '0');
            if(sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int)(sign * res);
        
    }
}