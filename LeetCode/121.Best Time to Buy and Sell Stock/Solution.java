public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int profit = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] > min) {
        profit = Math.max(profit, prices[i] - min);
      } else {
        min = prices[i];
      }
    }

    return profit;
  }
}