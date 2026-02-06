class Solution {
    public String reverseStr(String s, int k) {
        char[] arr=s.toCharArray();
        int idx = 0;
        int len = s.length();
        boolean reverse = true;
        while(idx<len){
           if(reverse){
            int left =idx;
            int right = Math.min(idx+k-1 , len-1);
            while(left<right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
           }
           idx +=k;
           reverse = !reverse;
        }
        return new String(arr);
    }
}