import java.util.Arrays;
import java.util.HashMap;

/**
 * 找出一个数的最少平方和， 例如10 ＝ 1 ＋ 9， 所以答案是2.
 *
 * 这道题一开始很容易想到贪心， 一直count最大的平房和，不过这个贪心是错误的，例如48用贪心解是 36 ＋ 9 ＋ 1 ＋ 1 ＋1，等于5， 但是正确答案是 16 ＋ 16 ＋ 16。
 * 所以这题用动态规划取做，方程dp[i]表示i可以得到的最少平房和， 所以dp［i］ ＝ Min(dp［k］ + dp［i－ k])
 */
public class shortestSqureSum {
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
      for (int j = 1; j < i; j++) {
        dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    shortestSqureSum test = new shortestSqureSum();
    System.out.println(test.shortestSqureSum(48));
  }
}
