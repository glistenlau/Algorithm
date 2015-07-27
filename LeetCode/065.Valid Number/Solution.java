public class Solution {
  public boolean isNumber(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }

    int i = 0;

    while(i < s.length() && s.charAt(i) == ' ') {
      i++;
    }

    validType check = checkValid(s, i, false);

    if (check.isValid) {
      i = check.index;
    } else {
      return false;
    }

    if (i < s.length() && s.charAt(i) == 'e') {
      i++;
      check = checkValid(s, i, false);

      if (check.isValid && !check.dot) {
        i = check.index;
      } else {
        return false;
      }

    }

    while(i < s.length() && s.charAt(i) == ' ') {
      i++;
    }

    return i == s.length();
  }

  private validType checkValid(String s, int i, boolean dot) {
    boolean sym = false;

    while (i < s.length() && !Character.isDigit(s.charAt(i))) {
      char c = s.charAt(i);

      if (c == '+' || c == '-' || c == '.') {
        if (c == '+' || c == '-') {
          if (sym || dot) {
            return new validType(false, dot, i);
          } else {
            sym = true;
          }
        }
        if (c == '.') {
          if (dot) {
            return new validType(false, dot, i);
          }
          dot = true;
        }
        i++;
      } else {
        return new validType(false, dot, i);
      }

    }

    if (i == s.length() || !Character.isDigit(s.charAt(i))) {
      return new validType(false, dot, i);
    }

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      i++;
    }

    if (i < s.length() && s.charAt(i) == '.') {
      if (dot) {
        return new validType(false, dot, i);
      } else {
        i++;
        dot = true;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          i++;
        }
      }
    }

    return new validType(true, dot, i);
  }

  private class validType {
    boolean isValid;
    boolean dot;
    int index;

    public validType(boolean isValid, boolean dot, int index) {
      this.isValid = isValid;
      this.dot = dot;
      this.index = index;
    }
  }
}