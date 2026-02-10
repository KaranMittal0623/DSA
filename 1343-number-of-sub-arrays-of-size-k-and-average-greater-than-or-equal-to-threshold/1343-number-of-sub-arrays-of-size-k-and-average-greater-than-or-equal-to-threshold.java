class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int currSum = 0;
        for(int i = 0;i<k;i++){
            currSum += arr[i];
        }
        int count = 0;
        for(int i=k;i<arr.length;i++){
            int avg = currSum/k;
            if(avg>=threshold){
                count++;
            }
            currSum -= arr[i-k];
            currSum += arr[i];
        }
        if(currSum/k>=threshold) count++;
        return count;
    }
}