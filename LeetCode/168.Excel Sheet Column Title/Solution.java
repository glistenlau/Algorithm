public class Solution {
  public String convertToTitle(int n) {
    StringBuilder result = new StringBuilder();
    int index = n;
    int r = 0;
    while (index > 0) {
      r = (index - 1) % 26;
      result.insert(0, (char) ('A' + r));
      index = (index - 1) / 26;
    }

    return result.toString();
  }
}