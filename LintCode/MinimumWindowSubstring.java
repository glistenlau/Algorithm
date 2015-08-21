/**
 * Minimum Window Substring
 * www.lintcode.com/en/problem/minimum-window-substring/
 *
 * Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
 *
 * Example
 * source = "ADOBECODEBANC", target = "ABC", Minimum window is "BANC".
 */
public class Solution {
  /**
   * @param source: A string
   * @param target: A string
   * @return: A string denote the minimum window
   *          Return "" if there is no such a string
   */
  public String minWindow(String source, String target) {
    if (source == null || target == null || source.length() < target.length()) {
      return "";
    }

    HashMap<Character, Integer> tar = new HashMap<>();
    getStringMap(target, tar);
    int n = target.length();
    int left = 0;
    String ans = null;

    for (int right = 0; right < source.length(); right++) {
      char cur = source.charAt(right);
      if (tar.containsKey(cur)) {
        if (tar.get(cur) > 0) {
          n--;
        }
        tar.put(cur, tar.get(cur) - 1);
      }
      source.low

      while (n <= 0) {
        if (ans == null || ans.length() > right - left + 1) {
          ans = source.substring(left, right + 1);
        }

        char r = source.charAt(left);
        if (tar.containsKey(r)) {
          if (tar.get(r) >= 0) {
            n++;
          }
          tar.put(r, tar.get(r) + 1);
        }
        left++;
      }
    }

    return ans == null? "": ans;
  }

  private void getStringMap(String s, HashMap<Character, Integer> map) {
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      if (!map.containsKey(cur)) {
        map.put(cur, 0);
      }

      map.put(cur, map.get(cur) + 1);
    }
  }
}
