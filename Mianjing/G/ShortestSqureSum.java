import java.util.Arrays;

/**
 * 找出一个数的最少平方和， 例如10 ＝ 1 ＋ 9， 所以答案是2.
 *
 * 这道题一开始很容易想到贪心， 一直count最大的平房和，不过这个贪心是错误的，例如48用贪心解是 36 ＋ 9 ＋ 1 ＋ 1 ＋1，等于5， 但是正确答案是 16 ＋ 16 ＋ 16。
 * 所以这题用动态规划取做，方程dp[i]表示i可以得到的最少平房和， 所以dp［i］ ＝ Min(dp［k］ + dp［i－ k])
 * Update: 之前的做法是每一个数都遍历一遍小于它自己的数，时间复杂度是O(n^2)， leetcode最近刚加了这题，跑了发现TLE，
 * 就发现这题可以在第二个循环中只遍历小于它的
 * 数的平方， 这样时间复杂度就是O(n*sqrt(n))， 时间复杂度减小了很多。
 */
public class ShortestSqureSum {
  public int shortestSqureSum(int n) {
    int s = (int) Math.sqrt(n);
    int[] dp = new int[n + 1];
    //初始化
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i = 1; i <= s; i++) {
      dp[i * i] = 1;
    }

    for (int i = 1; i <= n; i++) {
      if (dp[i] == 1) {
        continue;
      }
      for (int j = 1; j * j < i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    ShortestSqureSum test = new ShortestSqureSum();
    System.out.println(test.shortestSqureSum(48));
  }
}
