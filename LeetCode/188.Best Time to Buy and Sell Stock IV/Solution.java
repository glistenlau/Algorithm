public class Solution {
  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    if (k > prices.length / 2) {
      return getProfit(prices);
    }

    int[][] global = new int[prices.length][k + 1];
    int[][] local = new int[prices.length][k + 1];

    for (int i = 1; i < prices.length; i++) {
      int profit = prices[i] - prices[i - 1];
      for (int j = 1; j <= k; j++) {
        local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(profit, 0), local[i - 1][j] + profit);
        global[i][j] = Math.max(global[i - 1][j], local[i][j]);
      }
    }

    return global[prices.length - 1][k];
  }

  private int getProfit(int[] prices) {
    int sum = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        sum += prices[i] - prices[i - 1];
      }
    }

    return sum;
  }
}