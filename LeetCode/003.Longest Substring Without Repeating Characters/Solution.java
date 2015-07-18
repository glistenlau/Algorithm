public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] lookup = new int[256];
    int last = 0;
    int result = 0;
    Arrays.fill(lookup, -1);
    for (int i = 0; i <= s.length(); i++) {
      if (lookup[s.charAt(i)] != -1) {
        last = Math.max(lookup[s.charAt(i)] + 1, last);
      }
      result = Math.max(result, i - last + 1);
      lookup[s.charAt(i)] = i;
    }
    return result;
  }
}