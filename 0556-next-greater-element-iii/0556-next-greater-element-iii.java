class Solution {
    public int nextGreaterElement(int n) {
        // Traversing from right
        //Inc, Dec find the no. that will participate in the swaping
        // Reverse the number from there
        String s = String.valueOf(n);
        int i, len = s.length();
        char[] arr = s.toCharArray();
        // Finding the first point
        for(i=len-2;i>=0;i--){
            if(arr[i]<arr[i+1]) break;
        }

        if(i<0) return -1;

        // Find the second point
        for(int j=len-1;j>i;j--){
            if(arr[j]>arr[i]){
                swapChars(arr,j,i);
                break;
            }
        }

        // Make the right side correct by reversing 
        reverse(arr, i + 1, len - 1);

        // Convert back to long and check overflow
        long val = Long.parseLong(new String(arr));
        return (val > Integer.MAX_VALUE) ? -1 : (int) val;

    }
    public void swapChars(char[] arr, int i, int j) {
        

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swapChars(arr, i, j);
            i++;
            j--;
        }
    }
}