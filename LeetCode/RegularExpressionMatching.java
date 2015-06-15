import java.util.Arrays;

/**
 * Created by YiLIU on 6/13/15.
 */
public class RegularExpressionMatching {
  public boolean isMatchR(String s, String p) {
    int m = s.length();
    int n = p.length();

    if (m == 0) {
      if (n % 2 != 0){
        return false;
      } else {
        for (int i = 1; i < n; i += 2) {
          if (p.charAt(i) != '*') {
            return false;
          }
        }
      }
      return true;
    }

    if (n == 0) {
      return false;
    }

    if (n > 1 && p.charAt(1) == '*') {
      return isMatchR(s, p.substring(2)) || ((s.charAt(0)
          == p.charAt(0) || p.charAt(0) == '.') && isMatchR(s.substring(1), p));
    } else {
      return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatchR(s
          .substring(1), p.substring(1));
    }
  }

  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    boolean[][] isM = new boolean[m + 1][n + 1];
    isM[0][0] = true;

    for (int i = 1; i <= n; ++i) {
      isM[0][i] = i > 1 && p.charAt(i - 1) == '*' && isM[0][i - 2];
    }

    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (p.charAt(j - 1) != '*') {
          isM[i][j] = (p.charAt(j - 1) == s.charAt(i - 1) ||
              p.charAt(j - 1) == '.') && isM[i - 1][j - 1];
        } else {
          isM[i][j] = isM[i][j - 2] || (p.charAt(j - 2) == '.' || p.charAt(j -
              2) == s.charAt(i - 1)) && isM[i - 1][j];
        }
      }
    }
    return isM[m][n];
  }

  public static void main(String[] args) {
    System.out.println(new RegularExpressionMatching().isMatch("aaa",
        "ab*a*c*a"));
  }
}
