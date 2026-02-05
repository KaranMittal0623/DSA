class Solution {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            arr[i] = Character.toLowerCase(arr[i]);
        }
        s = new String(arr);
        return s;
    }
}