
// Solution1: Brute force
public class Solution {
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || haystack.length() < needle.length()) {
      return -1;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      int j = 0;
      for (j = 0; j < needle.length(); j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
      if (j == needle.length()) {
        return i;
      }
    }

    return -1;
  }
}

// Solution2: KMP
public class Solution {
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || haystack.length() < needle.length()) {
      return -1;
    }
    if (needle.length() == 0) {
      return 0;
    }

    int[] f = buildFunction(needle);

    int i = 0;
    int j = 0;

    while (i < haystack.length()) {
      if (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
        if (j == needle.length()) {
          return i - j;
        }
        continue;
      }

      if (j > 0) {
        j = f[j];
      } else {
        i++;
      }
    }

    return -1;
  }

  private int[] buildFunction(String needle) {
    int[] result = new int[needle.length() + 1];
    if (needle.length() == 0) {
      return result;
    }
    result[0] = 0;
    result[1] = 0;
    for (int i = 2; i < needle.length(); i++) {
      int j = result[i - 1];
      while(true) {
        if (needle.charAt(j) == needle.charAt(i - 1)) {
          result[i] = j + 1;
          break;
        }

        if (j == 0) {
          result[i] = 0;
          break;
        }
        j = result[j];
      }
    }
    return result;
  }
}