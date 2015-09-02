/**
 * Count and Say
 * www.lintcode.com/en/problem/count-and-say/
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1", or 11.
 * 11 is read off as "two 1s" ro 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Example
 * Given n = 5, return "111221".
 */
public class Solution {
  /**
   * @param n the nth
   * @return the nth sequence
   */
  public String countAndSay(int n) {
    // Write your code here
    if (n == 0) {
      return "";
    }

    String ans = "1";
    for (int i = 1; i < n; i++) {
      ans = countAndSay(ans);
    }
    return ans;
  }

  private String countAndSay(String s) {
    int index = 0;
    StringBuilder ans = new StringBuilder();

    while (index < s.length()) {
      int count = 0;
      char cur = s.charAt(index);
      while (index < s.length() && s.charAt(index) == cur) {
        index++;
        count++;
      }
      if (count != 0) {
        ans.append(count);
        ans.append(cur);
      }
    }

    return ans.toString();
  }
}
