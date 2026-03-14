class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0; i<n-1; i++){
            if(prices[i] < prices[i+1] && prices[i] < buy) buy = prices[i];
            profit = Math.max(profit,prices[i]-buy);
        }
        profit = Math.max(profit,prices[n-1]-buy);
        return profit;
    }
}