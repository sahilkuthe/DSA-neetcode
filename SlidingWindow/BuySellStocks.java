package SlidingWindow;

/**
 * BuySellStocks
 */
public class BuySellStocks {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currProfit = 0;
        int minBuy = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            minBuy = Math.min(prices[i], minBuy);
            currProfit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}