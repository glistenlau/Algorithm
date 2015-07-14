/**
 * Best Time to Buy and Sell Stock III
 * www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iii/
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 *
 * Design an algorithm to find the maximu profit. You may complete at most
 * two transactions.
 *
 * Example
 * Given an example [4, 4, 6, 1, 1, 4, 2, 5], return 6.
 */

class Solution {
  /**
   * @param prices: Given an integer array
   * @return: Maximum profit
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int max = Integer.MIN_VALUE;
    int min = prices[0];
    int[] left = new int[prices.length];
    for (int i = 1; i < prices.length; i++) {
      max = Math.max(max, prices[i] - min);
      min = Math.min(prices[i], min);
      left[i] = max;
    }

    max = Integer.MIN_VALUE;
    int afterMax = 0;
    int[] right = new int[prices.length];
    for (int i = prices.length - 1; i >= 0; i--) {
      max = Math.max(max, afterMax - prices[i]);
      afterMax = Math.max(afterMax, prices[i]);
      right[i] = max;
    }
    int result = 0;
    for (int i = 0; i < prices.length; i++) {
      result = Math.max(result, left[i] + right[i]);
    }
    return result;
  }

};
