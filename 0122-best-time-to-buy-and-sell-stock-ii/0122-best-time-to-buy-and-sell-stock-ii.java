class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int maxProfit=0;
        int buy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buy && prices[i]>prices[i-1]){
                int profit = prices[i] - buy;
                maxProfit = Math.max(profit,maxProfit);
                if(i==prices.length-1){
                    ans+=maxProfit;
                }
            }
            else{
                buy=prices[i];
                ans += maxProfit;
                maxProfit=0;
            }
        }
        return ans;
    }
}