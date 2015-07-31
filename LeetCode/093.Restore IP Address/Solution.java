public class Solution {
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<String>();
    if (s == null || s.length() == 0) {
      return result;
    }
    dfsHelper(s, 0, 0, new StringBuilder(), result);
    return result;
  }

  private void dfsHelper(String s, int pos, int n, StringBuilder taken, List<String> result) {
    if (n == 4) {
      if (pos == s.length()) {
        result.add(taken.toString());
      }
      return;
    }

    if (n != 0) {
      taken.append('.');
    }

    int preLen = taken.length();
    StringBuilder temp = new StringBuilder(3);

    for (int i = pos; i < pos + 3 && i < s.length(); i++) {
      if (temp.toString().equals("0")) {
        break;
      }
      temp.append(s.charAt(i));
      if (Integer.parseInt(temp.toString()) > 255) {
        break;
      }

      taken.append(temp.toString());
      dfsHelper(s, i + 1, n + 1, taken, result);
      taken.delete(preLen, taken.length());
    }

    if (n != 0) {
      taken.deleteCharAt(taken.length() - 1);
    }
  }
}