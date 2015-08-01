public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }

    boolean[][] isIL = new boolean[s1.length() + 1][s2.length() + 1];
    isIL[0][0] = true;

    for (int i = 1; i <= s1.length(); i++) {
      isIL[i][0] = isIL[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
    }

    for (int j = 1; j <= s2.length(); j++) {
      isIL[0][j] = isIL[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
    }

    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        isIL[i][j] = (isIL[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (isIL[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
      }
    }

    return isIL[s1.length()][s2.length()];
  }
}