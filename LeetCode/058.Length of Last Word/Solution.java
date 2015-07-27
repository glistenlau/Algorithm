public class Solution {
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int index = s.length() - 1;
    int count = 0;
    while (index >= 0) {
      if (s.charAt(index) == ' ') {
        index--;
        continue;
      }

      while (index >= 0 && s.charAt(index) != ' ') {
        count++;
        index--;
      }
      break;
    }
    return count;
  }
}