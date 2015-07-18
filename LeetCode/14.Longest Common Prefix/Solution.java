public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    String result = strs[0];

    for (int i = 1; i < strs.length; i++) {
      int len = Math.min(result.length(), strs[i].length());
      int j = 0;
      for (j = 0 ; j < len; j++) {
        if (result.charAt(j) != strs[i].charAt(j)) {
          break;
        }
      }
      result = j < result.length() ? result.substring(0, j) : result;
    }

    return result;
  }
}