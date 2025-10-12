class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        // Convert it to long and make n psitive
        long N = n;
        if(N<0){
            N = -N;
            x = 1/x;
        }

        // If n is even recursive square of its half to reduce the call x^8 = (x^4)^2
        if(N%2 == 0){
            return myPow(x*x , (int) N/2);
        }
        else{
            return x * myPow(x, (int)(N-1));
        }
    }
}