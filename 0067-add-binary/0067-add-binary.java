class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length()-1;
        int l2 = b.length()-1;
        int carry = 0, base = 2;
        StringBuilder res = new StringBuilder();
        while(l1>=0 || l2>=0){
            int t1=0,t2=0,sum;
            if(l1>=0){
                t1 = a.charAt(l1) - '0';
                l1--;
            }
            if(l2>=0){
                t2 = b.charAt(l2) - '0';
                l2--;
            }
            sum = t1 + t2 + carry;
            if(sum>=base){
                carry = 1;
                sum = sum - base;
            }
            else{
                carry = 0;
            }
            res.append(sum);
        }
        if(carry==1){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}