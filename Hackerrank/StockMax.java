import java.io.*;
import java.util.*;

public class StockMax {
  private class Node{
    int price;
    int index;
    Node( int price, int index){
      this.price = price;
      this.index = index;
    }
  }

  public long stockMax(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    long[] sum = new long[prices.length + 1];
    Node[] nodes = new Node[prices.length + 1];

    sum[0] = 0;
    nodes[0] = new Node(0, 0);
    long profit = 0;

    for (int i = 1; i <= prices.length; i++) {
      sum[i] = sum[i - 1] + prices[i - 1];
      nodes[i] = new Node(prices[i - 1], i);
    }

    Node pre = nodes[0];
    Arrays.sort(nodes, (o1, o2) -> o1.price - o2.price);

    for (int i = prices.length; i > 0; i--) {
      Node cur = nodes[i];
      if (cur.index > pre.index) {
        profit += (long)cur.price * (cur.index - pre.index - 1) - (sum[cur.index - 1] - sum[pre
            .index]);
        if (cur.index == prices.length) {
          break;
        }
        pre = cur;
      }
    }

    return profit;
  }

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named
    Solution. */
    StockMax test = new StockMax();
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      int N = in.nextInt();
      int[] prices = new int[N];

      for (int j = 0; j < N; j++) {
        prices[j] = in.nextInt();
      }

      System.out.println(test.stockMax(prices));
    }
  }
}