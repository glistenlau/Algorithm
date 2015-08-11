public class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<List<String>>();
    if (s == null || s.length() == 0) {
      return result;
    }

    dfs(s, 0, new ArrayList<String>(), result);
    return result;
  }

  private void dfs(String s, int pos, List<String> taken, List<List<String>> result) {
    if (pos >= s.length()) {
      result.add(new ArrayList<String>(taken));
      return;
    }

    for (int i = pos + 1; i <= s.length(); i++) {
      String temp = s.substring(pos, i);
      if (isPal(temp)) {
        taken.add(temp);
        dfs(s, i, taken, result);
        taken.remove(taken.size() - 1);
      }
    }
  }

  private boolean isPal(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}