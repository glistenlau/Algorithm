/**
 * Longest Substring with At Most K Distinct Characters
 * www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/
 *
 * Given a string s, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example
 * Given s = "eceba", k = 3,
 * T is "eceb" which its length is 4.
 */

public class Solution {
  /**
   * @param s : A string
   * @return : The length of the longest substring
   *           that contains at most k distinct characters.
   */
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0 || k == 0) {
      return 0;
    }

    HashMap<Character, Integer> countMap = new HashMap<>();
    int left = 0;
    int ans = 0;

    for (int right = 0; right < s.length(); right++) {
      Character cur = s.charAt(right);
      if (!countMap.containsKey(cur)) {
        countMap.put(cur, 0);
      }
      countMap.put(cur, countMap.get(cur) + 1);

      while (countMap.size() > k) {
        char r = s.charAt(left);
        if (countMap.get(r) == 1) {
          countMap.remove(r);
        } else {
          countMap.put(r, countMap.get(r) - 1);
        }
        left++;
      }

      ans = Math.max(ans, right - left + 1);
    }

    return ans;
  }
}
