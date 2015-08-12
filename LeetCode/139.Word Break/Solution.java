public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    if (s == null || s.length() == 0) {
      return true;
    }

    boolean[] inDict = new boolean[s.length() + 1];
    inDict[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = i - 1; j >= 0; j--) {
        inDict[i] |= wordDict.contains(s.substring(j, i)) && inDict[j];
      }
    }

    return inDict[s.length()];
  }
}