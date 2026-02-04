class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int L=0;
        int R=n-1;
        if(n<3) return false;
        while(L<n-1){
            if(arr[L]<arr[L+1]){
                L++;
            }
            else{
                break;
            }
        }
        if(L==n-1) return false;
        while(R>0){
            if(arr[R]<arr[R-1]){
                R--;
            }
            else{
                break;
            }
        }
        if(R==0) return false;
        return L==R;
    }
}