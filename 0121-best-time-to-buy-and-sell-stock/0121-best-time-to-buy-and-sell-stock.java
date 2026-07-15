class Solution {
    public int maxProfit(int[] prices) {
        int max_profit=0;
        int buy=prices[0];
        for(int i=1;i<prices.length;i++){
            int profit=prices[i]-buy;
            if(profit>max_profit){
                max_profit=profit;
            }
            if(prices[i]<buy){
                buy=prices[i];
            }
        }
        return max_profit;
    }
}