class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            
            // update minimum price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            
            // calculate profit
            int profit = prices[i] - minPrice;
            
            // update max profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
}