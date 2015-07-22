public class Solution {
  public String countAndSay(int n) {
    if (n == 0) {
      return "";
    }
    String result = "1";

    while (n > 1) {
      int count = 1;
      String pattern = "";
      for (int i = 0; i < result.length(); i++) {
        if (i != result.length() - 1 && result.charAt(i) == result.charAt(i + 1)) {
          count++;
          continue;
        }
        pattern += "" + count + result.charAt(i);
        count = 1;
      }
      result = pattern;
      n--;
    }

    return result;
  }
}