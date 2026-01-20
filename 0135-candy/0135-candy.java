class Solution {
    public int candy(int[] ratings) {
        // This can be done with prefix and suffix in 2 iteration on loop by first checking the previous element rating and in 2nd loop same from backside to be checked from from the adjacent sides for arr[i]

        int n = ratings.length;
        int ans[]= new int[n];
        for(int i=0;i<n;i++){
            ans[i] = 1;
        }
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                ans[i] = ans[i-1] + 1;;
            }
        }
        int total = ans[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                ans[i] = Math.max(ans[i],ans[i+1]+1);
            }
            total += ans[i];
        }
        return total;

    }
}