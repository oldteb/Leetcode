package dynamicProgramming;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *  
 * 
 * @author yunhe
 *
 */
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)  return 0;
        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];
        int local = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            local = Math.min(local, prices[i]);
            leftProfit[i] = i == 0 ?  0 : Math.max(leftProfit[i-1], prices[i] - local);
        }
        local = Integer.MIN_VALUE;
        for(int i = prices.length-2; i >= 0; i--){
            local = Math.max(local, prices[i+1]);
            rightProfit[i] = Math.max(rightProfit[i+1], local - prices[i+1]);
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }
        return maxProfit;
    }
}
