import java.util.Arrays;
import java.util.Scanner;

/**
 * 问在一个字符串的结尾最少插入多少个字符能使其变为回文, 并返回插入后的回文。
 */
public class ShortestPalindrome {
  // Solution 1: Brute Force
  public static class Soltuion {
    public String shortestPalindrome(String s) {
      int right = s.length() - 1;
      int left = 0;
      for (; left < s.length(); left++) {
        int j = 0;
        if (s.charAt(left) == s.charAt(right)) {
          while (left + j < right - j) {
            if (s.charAt(left + j) != s.charAt(right - j)) {
              break;
            }
            j++;
          }
          if (left + j >= right - j) {
            break;
          }
        }
      }

      return s + getPost(s, 0, left - 1);
    }

    private String getPost(String str, int s, int e) {
      if (s > e) {
        return "";
      }
      StringBuilder ans = new StringBuilder();
      for (int i = e; i >= s; i--) {
        ans.append(str.charAt(i));
      }
      return ans.toString();
    }
  }

  // Solution 2: Manacher's algorithm
  public static class Solution1 {
    public String shortestPalindrome(String s) {
      int[] p = new int[2 * s.length() + 3];
      int id = 0;
      int mx = 0;

      for (int i = 1; i < 2 * s.length() + 2; i++) {
        p[i] = mx > i? Math.min(p[2 * id - i], mx - i): 0;

        while (getChar(s, i + 1 + p[i]) == getChar(s, i - 1 - p[i])) {
          p[i]++;
        }

        if (i + p[i] > mx) {
          id = i;
          mx = i + p[i];
        }
      }


      int max = 0;
      int center = 0;
      for (int i = 1; i < 2 * s.length() + 2; i++) {
        if (i + p[i] >= 2 * s.length() && p[i] > max) {
          center = i;
          max = p[i];
        }
      }

      return s + appendStr(s, 0, s.length() - max - 1);
    }

    private char getChar(String s, int index) {
      if (index == 0) {
        return '^';
      } else if (index == 2 * s.length() + 2) {
        return '$';
      } else if (index % 2 == 1) {
        return '#';
      } else {
        return s.charAt((index - 1) / 2);
      }
    }

    private String appendStr(String s, int left, int right) {
      StringBuilder sb = new StringBuilder();
      for (int i = right; i >= left; i--) {
        sb.append(s.charAt(i));
      }

      return sb.toString();
    }
  }

  /**
   * Follow up: 能在任意位置插入字母，求插入最少字符获得回文
   * 这种问题一般用DP可以解，状态方程dp[i][j]表示字符串s中从i到j加入最少的字符变为的回文。
   * 所以状态转移方程是：1.当s.charAt(i) == s.charAt(j)时，dp[i][j] = s.charAt(i) + dp[i + 1][j - 1] + s.charAt(j).
   *                  2.当s.charAt(i) != s.charAt(j)时, dp[i][j] = Math.min((s.charAt(i) + dp[i+1][j] + s.charAt(i)).length(), (s.charAt(j) + dp[i][j - 1] + s.charAt(j)).length())
   * 初始化： dp[i][i] = s.substring(i, i + 1).
   * 结果：dp[0][len - 1].
   * 时间复杂度: O(n^2)， 空间复杂度：O(n^2)
   */
  public static class Solution2 {
    public String shortestPalindrome(String s) {
      String[][] dp = new String[s.length()][s.length()];

      for (int i = 0; i < s.length(); i++) {
        Arrays.fill(dp[i], "");
      }

      for (int i = 0; i < s.length(); i++) {
        dp[i][i] = s.substring(i, i + 1);
      }

      for (int len = 1; len < s.length(); len++) {
        for (int i = 0; i + len < s.length(); i++) {
          if (s.charAt(i) == s.charAt(i + len)) {
            dp[i][i + len] = s.substring(i, i + 1) + dp[i + 1][i + len - 1] + s.substring(i + len, i + len + 1);
          } else {
            dp[i][i + len] = dp[i][i + len - 1].length() < dp[i + 1][i + len].length()?
                s.substring(i + len, i + len + 1) + dp[i][i + len - 1] + s.substring(i + len, i + len + 1):
                s.substring(i, i + 1) + dp[i + 1][i + len] + s.substring(i, i + 1);
          }
        }
      }

      return dp[0][s.length() - 1];
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String test = in.next();
    String result = new Solution2().shortestPalindrome(test);
    System.out.println(result);
  }

}
