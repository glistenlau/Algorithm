import java.util.HashMap;

/**
 * Longest Repeating Subsequence
 * Given a string, find length of the longest repeating sub-sequence such that the two subsequences don’t
 * have same string character (means with the same index in the string) at same position, i.e., any i’th
 * character in the two subsequences shouldn’t have the same index in the original string.
 *
 * Examples:
 * Input: str = "abc"
 * Output: 0
 *
 * Input: str = "aab"
 * Output: 1
 * The two sub-sequence are 'a'(first) and 'a'(second).
 *
 * Input: str = "aabb"
 * Output: 2
 *
 * Input: str = "abbby"
 * Output: 2		(b1b2)  (b2b3)
 *
 * Input  str= “a1a2b1b2c1c2”
 * Output 3
 * a1b1c1
 * a2b2c2
 */
public class LongestRepeatingSubsequence {
  public int longestRepeatingSubsequence(String str) {
    HashMap<Character, Integer> map = new HashMap<>();

    int last = -1;
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char cur = str.charAt(i);
      if (map.containsKey(cur) && map.get(cur) > last) {
        last = map.get(cur);
        count++;
      }

      map.put(cur, i);
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(new LongestRepeatingSubsequence().longestRepeatingSubsequence("abc"));
    System.out.println(new LongestRepeatingSubsequence().longestRepeatingSubsequence("aab"));
    System.out.println(new LongestRepeatingSubsequence().longestRepeatingSubsequence("aabb"));
    System.out.println(new LongestRepeatingSubsequence().longestRepeatingSubsequence("abbby"));
    System.out.println(new LongestRepeatingSubsequence().longestRepeatingSubsequence("aabbcc"));
  }
}
