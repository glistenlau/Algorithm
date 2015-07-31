public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return s.charAt(0) == '0'? 0: 1;
    }

    int prePre = s.charAt(0) == '0'? 0: 1;
    int pre = s.charAt(1) == '0'? 0: prePre;
    pre += validLetter(s, 0, 1)? prePre: 0;
    int num = pre;

    for (int i = 2; i < s.length(); i++) {
      num = s.charAt(i) == '0'? 0: pre;
      if (validLetter(s, i - 1, i)) {
        num += prePre;
      }
      prePre = pre;
      pre = num;
    }
    return num;
  }

  private boolean validLetter(String s, int pre, int cur) {
    return s.charAt(pre) != '0' && (s.charAt(pre) - '0' < 2 || (s.charAt(pre) - '0' == 2 && s.charAt(cur) - '0' < 7));
  }
}