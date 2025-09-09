class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        // TO keep the trace of 1st and 2nd place 
        int[] res = new int[m+n];

        for(int i = m-1;i>=0;i--){
            int d1 = num1.charAt(i) - '0';
            for(int j = n-1;j>=0;j--){
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;
                // Get the position where to keep 1st and 2nd
                int p1 = i + j;
                int p2 = i + j + 1;
                // Calculate total value along with the upper portion
                int sum = mul + res[p2];
                // Replace the 1st and 2nd position with updated value
                res[p2] = sum%10;
                res[p1] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        // From the array create the string
        for(int num : res){
            if(!(sb.length() == 0 && num == 0)){
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}