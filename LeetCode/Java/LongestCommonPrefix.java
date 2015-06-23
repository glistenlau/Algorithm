/**
 * Created by YiLIU on 6/14/15.
 */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    int n = strs.length;
    if (n == 0) return "";
    int longest = strs[0].length();
    String e = strs[0];
    for (int i = 1; i < n; ++i) {
      int j = 0;
      while (j < e.length() && j < strs[i].length() && e.charAt(j) == strs[i]
          .charAt(j)) {
        ++j;
      }
      if (j < longest) {
        longest = j;
        e = strs[0].substring(0, j);
      }
    }
    return e;
  }

  public static void main(String[] args) {
    String[] test = {"hhhh", "hhkh"};
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(test));
  }
}
