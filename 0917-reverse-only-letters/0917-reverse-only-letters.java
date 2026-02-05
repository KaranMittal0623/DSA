class Solution {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        int left = 0;
        int right = len-1;
        char[] arr = s.toCharArray();
        while(left<=right){
            
            if(Character.isLetter(arr[left]) && Character.isLetter(arr[right])){
                char ch = arr[left];
                arr[left] = arr[right];
                arr[right] = ch;
                left++;
                right--;
            }else if(!Character.isLetter(arr[left])){
                left++;
            }
            else{
                right--;
            }
        }
        return new String(arr);
    }
}