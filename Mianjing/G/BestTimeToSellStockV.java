import java.util.prefs.BackingStoreException;

/**
 * 在第一题的基础上加了个限制，就是如果今天卖出股票，则第二天不能进行买进操作，需要隔一天，而就是说第三天才能；
 * 举例： 1，2，3，4，2，3，4； 则利润为4， 因为第一天买，第4天卖，第5天不能买，所以第六天买第7天卖。
 *
 * The problem has a constraint that we must wait one to buy again, so we can use a array
 * profit[i] to indicate the maximum profit we can get after sell a stock at ith day. So we know
 * if we sold a stock at i - 1 day, we can't buy stock or sell stock at ith day. If we sold stock
 * at i - 2 day, we can buy stock at ith day and then sell it, the profit is the same with i - 2
 * day. If we sold a stock at i - 3 day, we can buy the stock at i - 1 day, and sell it at ith
 * day. Also we can keep the stock at these day, and sell it at ith day;
 * So we have the transaction function:
 *   profit[i] = max(profit[i - 3] + (A[i] - A[i - 3]), max(profit[i - 3] + max(0, A[i] - A[i - 1]),
 *   profit[i - 2]));
 *
 * we can initiate the array:
 *   profit[0] = 0,
 *   profit[1] = max(0, A[1] - A[0]),
 *   profit[2] = max(0, A[2] - A[0]).
 *
 *
 * Another solution is use two arrays, one for maximum profit we have stock at that day,
 * another one is for maximum profit we don't have stock at that day.
 *
 * So we have the transaction function,
 *   hasStock[i] = Math.max(hasStock[i - 1], noStock[i - 2] - prices[i]);
 *   noStock[i] = Math.max(noStock[i - 1], hasStock[i - 1] + prices[i]);
 * Initiation:
 *   hasStock[0] = 0 - prices[0];
 *   noStock[0] = 0;
 * Return noStock[prices.length - 1].
 *
 */
public class BestTimeToSellStockV {
  public int bestTimeToSellStockV(int[] prices) {
    int[] profit = new int[prices.length];
    if (prices.length < 3) {
      return Math.max(0, prices[prices.length - 1] - prices[0]);
    }

    profit[0] = 0;
    profit[1] = Math.max(0, prices[1] - prices[0]);
    profit[2] = Math.max(0, prices[2] - prices[0]);

    int max = Math.max(0, Math.max(profit[1], profit[2]));

    for (int i = 3; i < prices.length; i++) {
      profit[i] = Math.max(profit[i - 3] + prices[i] - prices[i - 3],
          Math.max(profit[i - 3] + Math.max(0, prices[i] - prices[i - 1]), profit[i - 2]));

      max = Math.max(profit[i], max);
    }

    return max;
  }

  public int bestTimeToSellStockV1(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int[] noStock = new int[prices.length];
    int[] hasStock = new int[prices.length];

    hasStock[0] = 0 - prices[0];

    for (int i = 1; i < prices.length; i++) {
      noStock[i] = Math.max(noStock[i - 1], hasStock[i - 1] + prices[i]);

      if (i == 1) {
        hasStock[i] = Math.max(hasStock[0], 0 - prices[i]);
      } else {
        hasStock[i] = Math.max(hasStock[i - 1], noStock[i - 2] - prices[i]);
      }
    }

    return noStock[prices.length - 1];
  }



  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 4, 2, 3, 4, 12, 332, 43224, 3524};
    System.out.println(new BestTimeToSellStockV().bestTimeToSellStockV(prices));
    System.out.println(new BestTimeToSellStockV().bestTimeToSellStockV1(prices));

  }
}
