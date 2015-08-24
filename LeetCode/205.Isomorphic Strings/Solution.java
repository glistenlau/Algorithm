public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.equals(t)) {
      return true;
    }

    int[] replaced= new int[256];
    boolean[] mapped = new boolean[256];
    Arrays.fill(replaced, -1);
    char[] sChar = s.toCharArray();

    for (int i = 0 ; i < s.length(); i++) {
      if (replaced[sChar[i]] == -1) {
        if (mapped[t.charAt(i)]) {
          return false;
        } else {
          replaced[sChar[i]] = t.charAt(i);
          mapped[t.charAt(i)] = true;
        }
      } else {
        if (replaced[sChar[i]] != t.charAt(i)) {
          return false;
        }
      }
      sChar[i] = (char) replaced[sChar[i]];
    }

    return t.equals(new String(sChar));
  }
}