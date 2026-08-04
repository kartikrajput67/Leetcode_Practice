class Solution {
    public int maxProfit(int[] prices) {
        //1st approach - try all possible by two loops for each i(buy) and for each j(sell).

        //2nd Approach - buy on very 1st day then if I see the lesser value of stock then buy on that day else if greater value sell, calc max.

        int n = prices.length;
        int buy = prices[0];
        int maxProfit = 0;
        for(int i:prices){
            if(i < buy) buy = i;
            else maxProfit = Math.max(maxProfit, i-buy);
        }
        return maxProfit;
    }
}