public class Solution {
  public List<String> wordBreak(String s, Set<String> wordDict) {
    List<String> result = new ArrayList<String>();
    if (s == null || s.length() == 0) {
      return result;
    }

    boolean[] inDict = new boolean[s.length() + 1];
    inDict[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = i - 1; j >= 0; j--) {
        inDict[i] |= wordDict.contains(s.substring(j, i)) && inDict[j];
      }
    }

    if (inDict[s.length()]) {
      dfsHelper(s, 0, wordDict, new StringBuilder(), result);
    }

    return result;
  }

  private void dfsHelper(String s, int pos, Set<String> dict, StringBuilder taken, List<String> result) {
    if (pos >= s.length()) {
      result.add(taken.toString());
      return;
    }

    for (int i = pos + 1; i <= s.length(); i++) {
      String curt = s.substring(pos, i);
      if (dict.contains(curt)) {
        if (taken.length() != 0) {
          taken.append(' ');
        }

        taken.append(curt);
        dfsHelper(s, i, dict, taken, result);
        taken.delete(taken.length() - i + pos, taken.length());

        if (taken.length() != 0) {
          taken.deleteCharAt(taken.length() - 1);
        }
      }
    }

  }
}