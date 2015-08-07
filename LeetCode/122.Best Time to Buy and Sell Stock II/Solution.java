public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int curt = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] > curt) {
        profit += prices[i] - curt;
      }
      curt = prices[i];
    }

    return profit;
  }
}