class Solution {
    public int maxProfit(int[] prices) {
        // Maintain 3 variables and do linear search and maintain the three variables
        int buy_price = prices[0];
        int maxProfit = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]<buy_price){
                buy_price = prices[i];
            }
            else{
                int current_profit = prices[i] - buy_price;
                maxProfit = Math.max(current_profit,maxProfit);
            }
        }
        return maxProfit;
    }
}